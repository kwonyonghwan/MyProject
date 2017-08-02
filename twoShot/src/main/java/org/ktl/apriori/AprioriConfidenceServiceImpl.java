package org.ktl.apriori;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ktl.domain.LSupportData;
import org.ktl.domain.RuleConfidence;
import org.springframework.stereotype.Service;

@Service
public class AprioriConfidenceServiceImpl implements AprioriConfidenceService {


	// 규칙 생성.
	@Override
	public List<RuleConfidence> generateRules(LSupportData resultLS, Double minConfidence) {
		//System.out.println("== generateRules START\n");
		
		// (선행조건, 결과, 신뢰도)를 갖고 있는 RuleConfidene타입의 객체를 원소로 갖고 있는 리스트
		// 즉, 최소신뢰도를 만족하는 모든 규칙들의 리스트이다.
		List<RuleConfidence> ruleConfidenceList = new ArrayList<>();

		int LSize = resultLS.getL().size();

		// L의 길이만큼 반복하는데 L[1]번째 부터 접근한다.[0]은 만들 규칙조합이 없기때문.
		for (int i = 1; i < LSize; i++) {
			for (Set<Integer> freqSet : resultLS.getL().get(i)) {

				// freqSet을 단일 항목의 리스트인 H1으로 만든다.
				List<Set<Integer>> H1 = new ArrayList<>(new HashSet<>());
				H1 = createH1(freqSet);

				// L[1]까지는 바로 신뢰도 계산하면되고, L[2]부터는 규칙을 조합해야하므로 rulesfromconseq
				if (i > 1) {
					rulesFromConseq(freqSet, H1, resultLS, ruleConfidenceList, minConfidence);
				} else {
					calConf(freqSet, H1, resultLS, ruleConfidenceList, minConfidence);
				} // else

			} // L[i] 번쨰
		} // 리스트L 전체

		/*
		 * System.out.println("== 최종 생성된 규칙 및 신뢰도"); for (RuleConfidence
		 * ruleConfidence : ruleConfidenceList) {
		 * System.out.println(ruleConfidence);
		 * 
		 * }// for()
		 */
		//System.out.println("== generateRules--END\n");

		return ruleConfidenceList;
	}// generateRules()

	// 규칙의 신뢰도 계산 ( 매개변수 : freqSet, H1, 지지도값, 저장될 규칙리스트, 최소신뢰도)
	@Override
	public List<Set<Integer>> calConf(Set<Integer> freqSet, List<Set<Integer>> H1, LSupportData resultLS,
			List<RuleConfidence> ruleConfidenceList, Double minConf) {

		//System.out.println("== calConf--START\n");

		// prunedH : 최소신뢰도를 만족하는 규칙의 결과부를 저장하고 있는 리스트. 후에 이 길이가 1보다 길면 재귀적으로 규칙을
		// 만든다.
		List<Set<Integer>> prunedH = new ArrayList<>();

		Map<Set<Integer>, Double> supportData = resultLS.getSupportData();

		//System.out.println("- freqSet\n " + freqSet);
		for (Set<Integer> conseq : H1) {

			HashSet<Integer> differenceSet = new HashSet<>();
			differenceSet.addAll(freqSet);
			differenceSet.removeAll(conseq);
			// 현재 differenceSet은 freqSet-conseq(차집합)이다.

			// freqSet이나 defferenceSet에 대한 지지도 값이 supportData에 없다는 말은 빈발집합이 아니라는
			// 뜻이기 때문에 continue 해서 다음것 확인
			if (supportData.get(freqSet) == null || supportData.get(differenceSet) == null) {
				continue;
			} // if()

			// 신뢰도 = S(freqSet) / S(freqSet-conseq)
			Double confidence = supportData.get(freqSet) / supportData.get(differenceSet);

			// 계산한 신뢰도가 최소신뢰도를 만족하면
			if (confidence >= minConf) {
				// freqSet-conseq, freqSet, 계산된 신뢰도를 ruleConfidenceList에 추가한다.
				RuleConfidence rc = new RuleConfidence();

				rc.setStart(differenceSet);
				rc.setEnd((HashSet) conseq);
				rc.setConfidence(confidence);

				// 규칙리스트에 최소신뢰도를 만족하는 규칙을 추가한다.
				ruleConfidenceList.add(rc);

				// 그리고 이 conseq를 prunedH 에도 추가해준다.
				prunedH.add(conseq);

			} // if()

		} // for()
			// 현재 freqSet으로 만들어질 수 있는 규칙들 중에서 최소신뢰도를 만족하는 것들이
			// ruleConfidenceList에 있고,
			// 해당 규칙들의 결과부 들이 prunedH에 들어있다.

		//System.out.println("- ruleConfidenceList\n" + ruleConfidenceList);
		//System.out.println("- prunedH\n" + prunedH);

		//System.out.println("== calConf--END\n");

		return prunedH;
	}// calConf()

	// H1 생성
	@Override
	public List<Set<Integer>> createH1(Set<Integer> set) {

		List<Set<Integer>> H1 = new ArrayList<>(new HashSet<>());

		for (Integer item : set) {
			HashSet<Integer> temp = new HashSet<Integer>();
			temp.add(item);
			H1.add(temp);
		}

		return H1;
	}// createH1()

	// L[i]의 한 집합의 길이가 3개 이상인 경우 부터 처리해주는 함수
	@Override
	public void rulesFromConseq(Set<Integer> freqSet, List<Set<Integer>> H, LSupportData resultLS,
			List<RuleConfidence> ruleConfidenceList, Double minConfidence) {
		//System.out.println("== rulesFromConseq--START\n");
		//System.out.println(
		//		"freqSet" + freqSet + "" + "\nH" + H + "\nresultLS" + resultLS + "\nminConfidence" + minConfidence);

		//System.out.println("=================================");

		// 규칙출력
		//for (RuleConfidence ruleConfidence : ruleConfidenceList) {
		//	System.out.println(ruleConfidence);
		//} // for()

		//System.out.println("=================================");

		AprioriSupportService aprioriSupport = new AprioriSupportServiceImpl();// aprioriGen
																			// 쓰기위함.

		List<Set<Integer>> Hmp1 = new ArrayList<>();// 새로 만들어지는 결과부의 집합 Hmp1을
													// 만든다.

		int m = H.get(0).size();
		//System.out.println("- m " + m + "\n");

		if (freqSet.size() > (m + 1)) {
			Hmp1 = aprioriSupport.aprioriGen(H, m + 1);

			Hmp1 = calConf(freqSet, Hmp1, resultLS, ruleConfidenceList, minConfidence);
			//System.out.println("Hmp1.get(0).size() :" + Hmp1.get(0).size() + "Hmp1.get(0) :" + Hmp1.get(0));

			if (Hmp1.size() > 1) {
				rulesFromConseq(freqSet, Hmp1, resultLS, ruleConfidenceList, minConfidence);
			} // if()
		} // if()

		//System.out.println("== rulesFromConseq--END\n");
		// return
	}// rulesFromConseq()

}// class
