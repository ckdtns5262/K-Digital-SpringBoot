package com.anno;

import java.lang.reflect.Method;

public class AnnoTestMain {
	
	@MyAnnotation(count = 5)  // Annotation의 count를 바꾸거나 수정하면 프린트출력횟수 바뀌거나 주석처리하면 else문에 따라 한번만 출력됨
	public static void print() {
		System.out.println("프린트임.");
	}
			
	public static void main(String[] args) throws Exception {
		
		
//		AnnoTestMain at = new AnnoTestMain();
//		at.getClass();
		
		Method m = AnnoTestMain.class.getMethod("print");  //위와 똑같은 return 값
		
		// MyAnnotaion.class을 가지고 있는지 확인
		if(m.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation method = m.getAnnotation(MyAnnotation.class);
			for(int i=0; i < method.count(); i++) {
			print();
			}
		} else {
		
			print();
		}
		
	
	}

}
