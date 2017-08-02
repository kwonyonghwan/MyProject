package org.ktl.util;

import java.util.HashMap;
import java.util.Map;

public class Maps {

	//남자 치수 저장할 맵
	private Map<Integer,Integer> msize200 = new HashMap<>();
	private Map<Integer,Integer> msize205 = new HashMap<>();
	private Map<Integer,Integer> msize210 = new HashMap<>();
	private Map<Integer,Integer> msize215 = new HashMap<>();
	private Map<Integer,Integer> msize220 = new HashMap<>();
	private Map<Integer,Integer> msize225 = new HashMap<>();
	private Map<Integer,Integer> msize230 = new HashMap<>();
	private Map<Integer,Integer> msize235 = new HashMap<>();
	private Map<Integer,Integer> msize240 = new HashMap<>();
	private Map<Integer,Integer> msize245 = new HashMap<>();
	private Map<Integer,Integer> msize250 = new HashMap<>();
	private Map<Integer,Integer> msize255 = new HashMap<>();
	private Map<Integer,Integer> msize260 = new HashMap<>();
	private Map<Integer,Integer> msize265 = new HashMap<>();
	private Map<Integer,Integer> msize270 = new HashMap<>();
	private Map<Integer,Integer> msize275 = new HashMap<>();
	private Map<Integer,Integer> msize280 = new HashMap<>();
	private Map<Integer,Integer> msize285 = new HashMap<>();
	private Map<Integer,Integer> msize290 = new HashMap<>();
	private Map<Integer,Integer> msize295 = new HashMap<>();
	private Map<Integer,Integer> msize300 = new HashMap<>();
	
	private Map<Integer,Map<Integer,Integer>> manFoot = new HashMap<>();
	
	//여자 치수 저장할 맵
	private Map<Integer,Integer> wsize195 = new HashMap<>();
	private Map<Integer,Integer> wsize200 = new HashMap<>();
	private Map<Integer,Integer> wsize205 = new HashMap<>();
	private Map<Integer,Integer> wsize210 = new HashMap<>();
	private Map<Integer,Integer> wsize215 = new HashMap<>();
	private Map<Integer,Integer> wsize220 = new HashMap<>();
	private Map<Integer,Integer> wsize225 = new HashMap<>();
	private Map<Integer,Integer> wsize230 = new HashMap<>();
	private Map<Integer,Integer> wsize235 = new HashMap<>();
	private Map<Integer,Integer> wsize240 = new HashMap<>();
	private Map<Integer,Integer> wsize245 = new HashMap<>();
	private Map<Integer,Integer> wsize250 = new HashMap<>();
	private Map<Integer,Integer> wsize255 = new HashMap<>();
	private Map<Integer,Integer> wsize260 = new HashMap<>();
	private Map<Integer,Integer> wsize265 = new HashMap<>();
	private Map<Integer,Integer> wsize270 = new HashMap<>();
	
	private Map<Integer,Map<Integer,Integer>> womanFoot = new HashMap<>();
	public Maps(){
		
		//남자 신발 사이즈 표 
		msize200.put(79, 189);msize200.put(81, 195);msize200.put(83, 201);msize200.put(85, 207);msize200.put(87, 213);msize200.put(89, 219);msize200.put(91, 225);msize200.put(93, 231);msize200.put(96, 237);msize200.put(98, 243);
		msize205.put(81, 192);msize205.put(83, 198);msize205.put(85, 204);msize205.put(87, 210);msize205.put(89, 216);msize205.put(91, 222);msize205.put(93, 228);msize205.put(95, 234);msize205.put(97, 240);msize205.put(99	, 246);
		msize210.put(82, 195);msize210.put(84, 201);msize210.put(86, 207);msize210.put(88, 213);msize210.put(90, 219);msize210.put(92, 225);msize210.put(94, 231);msize210.put(96, 237);msize210.put(98, 243);msize210.put(100, 249);
		msize215.put(83, 198);msize215.put(85, 204);msize215.put(87, 210);msize215.put(89, 216);msize215.put(91, 222);msize215.put(93, 228);msize215.put(95, 234);msize215.put(97, 240);msize215.put(99, 246);msize215.put(101, 252);
		msize220.put(84, 201);msize220.put(86, 207);msize220.put(88, 213);msize220.put(90, 219);msize220.put(92, 225);msize220.put(94, 231);msize220.put(96, 237);msize220.put(98, 243);msize220.put(100, 249);msize220.put(102, 255);
		msize225.put(85, 204);msize225.put(87, 210);msize225.put(89, 216);msize225.put(92, 222);msize225.put(94, 228);msize225.put(96, 234);msize225.put(98, 240);msize225.put(100, 246);msize225.put(102, 252);msize225.put(104, 258);
		msize230.put(87, 207);msize230.put(89, 213);msize230.put(91, 219);msize230.put(93, 225);msize230.put(95, 231);msize230.put(97, 237);msize230.put(99, 243);msize230.put(101, 249);msize230.put(103, 255);msize230.put(105, 261);
		msize235.put(88, 210);msize235.put(90, 216);msize235.put(92, 222);msize235.put(94, 228);msize235.put(96, 234);msize235.put(98, 240);msize235.put(100, 246);msize235.put(102, 252);msize235.put(104, 258);msize235.put(106, 264);
		msize240.put(89, 213);msize240.put(91, 219);msize240.put(93, 225);msize240.put(95, 231);msize240.put(97, 237);msize240.put(99, 243);msize240.put(101, 249);msize240.put(103, 255);msize240.put(105, 261);msize240.put(107, 267);
		msize245.put(90, 216);msize245.put(92, 222);msize245.put(94, 228);msize245.put(96, 234);msize245.put(98, 240);msize245.put(100, 246);msize245.put(103, 252);msize245.put(105, 258);msize245.put(107, 264);msize245.put(109, 270);
		msize250.put(92, 219);msize250.put(94, 225);msize250.put(96, 231);msize250.put(98, 237);msize250.put(100, 243);msize250.put(102, 249);msize250.put(104, 255);msize250.put(106, 261);msize250.put(108, 267);msize250.put(110, 273);
		msize255.put(93, 222);msize255.put(95, 228);msize255.put(97, 234);msize255.put(99, 240);msize255.put(101, 246);msize255.put(103, 252);msize255.put(105, 258);msize255.put(107, 264);msize255.put(109, 270);msize255.put(111, 276);
		msize260.put(94, 225);msize260.put(96, 231);msize260.put(98, 237);msize260.put(100, 243);msize260.put(102, 249);msize260.put(104, 255);msize260.put(106, 261);msize260.put(108, 267);msize260.put(110, 273);msize260.put(112, 279);
		msize265.put(95, 228);msize265.put(97, 234);msize265.put(99, 240);msize265.put(101, 246);msize265.put(103, 252);msize265.put(105, 258);msize265.put(107, 264);msize265.put(109, 270);msize265.put(111, 276);msize265.put(114, 282);
		msize270.put(96, 231);msize270.put(99, 237);msize270.put(101, 243);msize270.put(103, 249);msize270.put(105, 255);msize270.put(107, 261);msize270.put(109, 267);msize270.put(111, 273);msize270.put(113, 279);msize270.put(115, 285);
		msize275.put(98, 234);msize275.put(100, 240);msize275.put(102, 246);msize275.put(104, 252);msize275.put(106, 258);msize275.put(108, 264);msize275.put(110, 270);msize275.put(112, 276);msize275.put(114, 282);msize275.put(116, 288);
		msize280.put(99, 237);msize280.put(101, 243);msize280.put(103, 249);msize280.put(105, 255);msize280.put(107, 261);msize280.put(109, 267);msize280.put(111, 273);msize280.put(113, 279);msize280.put(115, 285);msize280.put(117, 291);
		msize285.put(100, 240);msize285.put(102, 246);msize285.put(104, 252);msize285.put(106, 258);msize285.put(108, 264);msize285.put(110, 270);msize285.put(112, 276);msize285.put(114, 282);msize285.put(116, 288);msize285.put(118, 294);
		msize290.put(101, 243);msize290.put(103, 249);msize290.put(105, 255);msize290.put(107, 261);msize290.put(110, 267);msize290.put(112, 273);msize290.put(114, 279);msize290.put(116, 285);msize290.put(118, 291);msize290.put(120, 297);
		msize295.put(103, 246);msize295.put(105, 252);msize295.put(107, 258);msize295.put(109, 264);msize295.put(111, 270);msize295.put(113, 276);msize295.put(115, 282);msize295.put(117, 288);msize295.put(119, 294);msize295.put(121, 300);
		msize300.put(104, 249);msize300.put(106, 255);msize300.put(108, 261);msize300.put(110, 267);msize300.put(112, 273);msize300.put(114, 279);msize300.put(116, 285);msize300.put(118, 291);msize300.put(120, 297);msize300.put(122, 203);
	
		manFoot.put(200, msize200);manFoot.put(205, msize205);manFoot.put(210, msize210);manFoot.put(215, msize215);manFoot.put(220, msize220);manFoot.put(225, msize225);manFoot.put(230, msize230);manFoot.put(235, msize235);manFoot.put(240, msize240);manFoot.put(245, msize245);manFoot.put(250, msize250);manFoot.put(255, msize255);manFoot.put(260, msize260);manFoot.put(265, msize265);manFoot.put(270, msize270);manFoot.put(275, msize275);manFoot.put(280, msize280);manFoot.put(285, msize285);manFoot.put(290, msize290);manFoot.put(295, msize295);manFoot.put(300, msize300);
		
		//여자 신발 사이즈 표
		wsize195.put(76, 183);wsize195.put(78, 189);wsize195.put(81, 195);wsize195.put(83, 201);wsize195.put(85, 207);wsize195.put(87, 213);wsize195.put(89, 219);wsize195.put(91, 225);wsize195.put(93, 231);
		wsize200.put(78, 186);wsize200.put(80, 192);wsize200.put(82, 198);wsize200.put(84, 204);wsize200.put(86, 210);wsize200.put(88, 216);wsize200.put(90, 222);wsize200.put(92, 228);wsize200.put(94, 234);
		wsize205.put(79, 189);wsize205.put(81, 195);wsize205.put(83, 201);wsize205.put(85, 207);wsize205.put(87, 213);wsize205.put(89, 219);wsize205.put(91, 225);wsize205.put(93, 231);wsize205.put(96, 237);
		wsize210.put(80, 192);wsize210.put(82, 198);wsize210.put(84, 204);wsize210.put(86, 210);wsize210.put(88, 216);wsize210.put(91, 222);wsize210.put(93, 228);wsize210.put(95, 234);wsize210.put(97, 240);
		wsize215.put(81, 195);wsize215.put(83, 201);wsize215.put(86, 207);wsize215.put(88, 213);wsize215.put(90, 219);wsize215.put(92, 225);wsize215.put(94, 231);wsize215.put(96, 237);wsize215.put(98, 243);
		wsize220.put(83, 198);wsize220.put(84, 204);wsize220.put(87, 210);wsize220.put(89, 216);wsize220.put(91, 222);wsize220.put(93, 228);wsize220.put(95, 234);wsize220.put(97, 240);wsize220.put(99, 246);
		wsize225.put(84, 201);wsize225.put(86, 207);wsize225.put(88, 213);wsize225.put(90, 219);wsize225.put(92, 225);wsize225.put(94, 231);wsize225.put(96, 237);wsize225.put(99, 243);wsize225.put(101, 249);
		wsize230.put(85, 204);wsize230.put(87, 210);wsize230.put(89, 216);wsize230.put(91, 222);wsize230.put(94, 228);wsize230.put(96, 234);wsize230.put(98, 240);wsize230.put(100, 246);wsize230.put(102, 252);
		wsize235.put(86, 207);wsize235.put(89, 213);wsize235.put(91, 219);wsize235.put(93, 225);wsize235.put(95, 231);wsize235.put(97, 237);wsize235.put(99, 243);wsize235.put(101, 249);wsize235.put(103, 255);
		wsize240.put(88, 210);wsize240.put(90, 216);wsize240.put(92, 222);wsize240.put(94, 228);wsize240.put(96, 234);wsize240.put(98, 240);wsize240.put(100, 246);wsize240.put(102, 252);wsize240.put(104, 258);
		wsize245.put(89, 213);wsize245.put(91, 219);wsize245.put(93, 225);wsize245.put(95, 231);wsize245.put(97, 237);wsize245.put(99, 243);wsize245.put(101, 249);wsize245.put(104, 255);wsize245.put(106, 261);
		wsize250.put(90, 216);wsize250.put(92, 222);wsize250.put(94, 228);wsize250.put(96, 234);wsize250.put(99, 240);wsize250.put(101, 246);wsize250.put(103, 252);wsize250.put(105, 258);wsize250.put(107, 264);
		wsize255.put(91, 219);wsize255.put(94, 225);wsize255.put(96, 231);wsize255.put(98, 237);wsize255.put(100, 243);wsize255.put(102, 249);wsize255.put(104, 255);wsize255.put(106, 261);wsize255.put(108, 267);
		wsize260.put(93, 222);wsize260.put(95, 228);wsize260.put(97, 234);wsize260.put(99, 240);wsize260.put(101, 246);wsize260.put(103, 252);wsize260.put(105, 258);wsize260.put(107, 264);wsize260.put(109, 270);
		wsize265.put(94, 225);wsize265.put(96, 231);wsize265.put(98, 237);wsize265.put(100, 243);wsize265.put(102, 249);wsize265.put(104, 255);wsize265.put(107, 261);wsize265.put(109, 267);wsize265.put(111, 273);
		wsize270.put(95, 228);wsize270.put(97, 234);wsize270.put(99, 240);wsize270.put(102, 246);wsize270.put(104, 252);wsize270.put(106, 258);wsize270.put(108, 264);wsize270.put(110, 270);wsize270.put(112, 276);
		
		womanFoot.put(195, wsize195);womanFoot.put(200, wsize200);womanFoot.put(205, wsize205);womanFoot.put(210, wsize210);womanFoot.put(215, wsize215);womanFoot.put(220, wsize220);womanFoot.put(225, wsize225);womanFoot.put(230, wsize230);womanFoot.put(235, wsize235);womanFoot.put(240, wsize240);womanFoot.put(245, wsize245);womanFoot.put(250, wsize250);womanFoot.put(255, wsize255);womanFoot.put(260, wsize260);womanFoot.put(265, wsize265);womanFoot.put(270, wsize270);
	}
	public Map<Integer, Integer> getMsize200() {
		return msize200;
	}
	public Map<Integer, Integer> getMsize205() {
		return msize205;
	}
	public Map<Integer, Integer> getMsize210() {
		return msize210;
	}
	public Map<Integer, Integer> getMsize215() {
		return msize215;
	}
	public Map<Integer, Integer> getMsize220() {
		return msize220;
	}
	public Map<Integer, Integer> getMsize225() {
		return msize225;
	}
	public Map<Integer, Integer> getMsize230() {
		return msize230;
	}
	public Map<Integer, Integer> getMsize235() {
		return msize235;
	}
	public Map<Integer, Integer> getMsize240() {
		return msize240;
	}
	public Map<Integer, Integer> getMsize245() {
		return msize245;
	}
	public Map<Integer, Integer> getMsize250() {
		return msize250;
	}
	public Map<Integer, Integer> getMsize255() {
		return msize255;
	}
	public Map<Integer, Integer> getMsize260() {
		return msize260;
	}
	public Map<Integer, Integer> getMsize265() {
		return msize265;
	}
	public Map<Integer, Integer> getMsize270() {
		return msize270;
	}
	public Map<Integer, Integer> getMsize275() {
		return msize275;
	}
	public Map<Integer, Integer> getMsize280() {
		return msize280;
	}
	public Map<Integer, Integer> getMsize285() {
		return msize285;
	}
	public Map<Integer, Integer> getMsize290() {
		return msize290;
	}
	public Map<Integer, Integer> getMsize295() {
		return msize295;
	}
	public Map<Integer, Integer> getMsize300() {
		return msize300;
	}
	public Map<Integer, Map<Integer, Integer>> getManFoot() {
		return manFoot;
	}
	public Map<Integer, Integer> getWsize195() {
		return wsize195;
	}
	public Map<Integer, Integer> getWsize200() {
		return wsize200;
	}
	public Map<Integer, Integer> getWsize205() {
		return wsize205;
	}
	public Map<Integer, Integer> getWsize210() {
		return wsize210;
	}
	public Map<Integer, Integer> getWsize215() {
		return wsize215;
	}
	public Map<Integer, Integer> getWsize220() {
		return wsize220;
	}
	public Map<Integer, Integer> getWsize225() {
		return wsize225;
	}
	public Map<Integer, Integer> getWsize230() {
		return wsize230;
	}
	public Map<Integer, Integer> getWsize235() {
		return wsize235;
	}
	public Map<Integer, Integer> getWsize240() {
		return wsize240;
	}
	public Map<Integer, Integer> getWsize245() {
		return wsize245;
	}
	public Map<Integer, Integer> getWsize250() {
		return wsize250;
	}
	public Map<Integer, Integer> getWsize255() {
		return wsize255;
	}
	public Map<Integer, Integer> getWsize260() {
		return wsize260;
	}
	public Map<Integer, Integer> getWsize265() {
		return wsize265;
	}
	public Map<Integer, Integer> getWsize270() {
		return wsize270;
	}
	public Map<Integer, Map<Integer, Integer>> getWomanFoot() {
		return womanFoot;
	}
	
}
