package org.ktl.apriori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.ktl.domain.LSupportData;
import org.ktl.domain.LkSupport;
import org.springframework.stereotype.Service;

@Service
public class AprioriSupportServiceImpl implements AprioriSupportService {

	// C1생성
	@Override
	public List<Set<Integer>> createC1(List<Set<Integer>> dataSetList) {
		//System.out.println("== createC1--start");
		List<Set<Integer>> C1 = new ArrayList<>(new HashSet<>());
		// System.out.println(dataSetList);

		for (Set<Integer> transaction : dataSetList) {
			for (Integer item : transaction) {
				if (C1.contains(new HashSet<>(Arrays.asList(item))) == false) {
					C1.add(new HashSet<>(Arrays.asList(item)));
				}
			}
		}
		//System.out.println("C1 :" + C1);

		//System.out.println("== createC1--end\n");

		return C1;
	}// createC1()

	// 항목 출현횟수 카운팅
	@Override
	public LkSupport scanD(List<Set<Integer>> dataSetList, List<Set<Integer>> Ck, Double minSupport) {

		//System.out.println("== scanD--start");
		// System.out.println("dataSetList :" + dataSetList + "\n C1 :" + Ck +
		// "\n minSupport :" + minSupport);

		Map<Set<Integer>, Integer> numberOfItemsMap = new HashMap<>();
		Map<Set<Integer>, Double> itemSupportMap = new HashMap<>();

		List<Set<Integer>> Lk = new ArrayList<>();

		for (Set<Integer> transaction : dataSetList) {
			for (Set<Integer> item : Ck) {

				if (transaction.containsAll(item)) {
					// System.out.println(transaction+"-----"+item);
					if (numberOfItemsMap.containsKey(item)) {
						numberOfItemsMap.put(item, numberOfItemsMap.get(item) + 1);
					} else {
						numberOfItemsMap.put(item, 1);
					} // else
				} // if
			} // for
		} // for

		//System.out.println("numberOfItemsMap :" + numberOfItemsMap);

		// 현재 C1의 각항목에 대한 계수가 된 상태이다. 이제 지지도를 계산해!
		// 전체 트랜잭션들의 수
		Double dataSetListSize = (double) dataSetList.size();

		// 항목들이 계수된 맵에서 key들을 가져온다.(순회하기 위해)
		Iterator keys = numberOfItemsMap.keySet().iterator();

		while (keys.hasNext()) {

			Set<Integer> key = (Set<Integer>) keys.next();

			Double support = numberOfItemsMap.get(key) / dataSetListSize;

			// 계산된 지지도가 최소지지도를 만족하면 이 항목을 Lk와 지지도 맵에 넣어준다.
			if (support >= minSupport) {
				itemSupportMap.put(key, support);

				// 함수형태인 key를 오름차순으로 정렬한후 빈발항목리스트인 Lk에 추가해준다.
				key = setSort(key);
				// System.out.println(key);
				Lk.add(Collections.unmodifiableSet(key));
			} // if
		} // while

		//System.out.println("Lk : " + Lk);
		//System.out.println("itemSupportMap : " + itemSupportMap);

		LkSupport ls = new LkSupport();

		ls.setLk(Lk);
		ls.setItemSupportMap(itemSupportMap);

		//System.out.println("== scanD--end\n");

		return ls;
	}// scanD()

	// Lk-1로부터 Ck만드는 함수
	// 이미 만들어진 Lk로 Ck+1을 만드는 함수.
	@Override
	public List<Set<Integer>> aprioriGen(List<Set<Integer>> Lk, Integer k) {
		//System.out.println("== aprioriGen--start\n");
		// 결과 리스트 즉, Ck+1을 만든다
		List<Set<Integer>> nextCk = new ArrayList<>();

		// Lk의 사이즈를 구함
		Integer LkSize = Lk.size();

		// Lk의 사이즈 동안
		for (int i = 0; i < LkSize; i++) {
			for (int j = i + 1; j < LkSize; j++) {
				// i일때 모든 j에 대해 돌아서
				List TempList_I = new ArrayList<>(Lk.get(i));
				List TempList_J = new ArrayList<>(Lk.get(j));
				//
				if (TempList_I.subList(0, k - 2).equals(TempList_J.subList(0, k - 2))) {
					Set<Integer> unionSet = new HashSet<>();

					unionSet.addAll(Lk.get(i));
					unionSet.addAll(Lk.get(j));

					nextCk.add(unionSet);
				}
			} // for()
		} // for()

		//System.out.println("nextCk :" + nextCk);

		//System.out.println("== aprioriGen--end\n");
		return nextCk;
	}// aprioriGen()

	// Set타입 원소들 오름차순 정렬
	@Override
	public Set<Integer> setSort(Set<Integer> key) {
		TreeSet<Integer> tempTree = new TreeSet<>(key);
		return tempTree;
	}

	// apriori 메소드
	@Override
	public LSupportData apriori(List<Set<Integer>> dataSetList, Double minSupport) {
		//System.out.println("== apriori--start\n");
		LkSupport ls = new LkSupport();
		LSupportData finalLS = new LSupportData();
		List<Set<Integer>> C1 = new ArrayList<>(new HashSet<>());

		Integer k;

		// C1 생성
		C1 = createC1(dataSetList);

		// L1 및 지지도맵 생성
		ls = scanD(dataSetList, C1, minSupport);

		// =======================================================

		// 만들어진 Lk와 이에 대한 지지도 맵을 을 최종 결과를 담는 fianlLS의 L과 supportData에 각각 추가
		finalLS.setL(ls.getLk());
		finalLS.setSupportData((ls.getItemSupportMap()));

		// System.out.println("- finalLS\n" + finalLS);

		k = 2;

		// L[k-2]의 길이>0 동안 반복
		while (finalLS.getL().get(k - 2).size() > 0) {

			List<Set<Integer>> Ck = new ArrayList<>(new HashSet<>());

			// Lk-1을 가지고 Ck를 생성
			Ck = aprioriGen(finalLS.getL().get(k - 2), k);
			//System.out.println("- Ck\n" + Ck);

			ls = scanD(dataSetList, Ck, minSupport);
			//System.out.println("- ls\n" + ls);

			// 만들어진 Lk와 이에 대한 지지도 맵을 을 최종 결과를 담는 fianlLS의 L과 supportData에 각각 추가
			finalLS.setL(ls.getLk());
			finalLS.setSupportData((ls.getItemSupportMap()));

			k++;

		} // while

		//System.out.println("- L\n" + finalLS.getL());

		//System.out.println("- supportData\n" + finalLS.getSupportData());

		//System.out.println("== apriori--end\n");

		return finalLS;
	}// apriori()

}// class
