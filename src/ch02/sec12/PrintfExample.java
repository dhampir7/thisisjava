//콘솔로 변수값 출력
package ch02.sec12;

public class PrintfExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품의 가격: %d원\n", value);      //정수  출력
        System.out.printf("상품의 가격: %6d원\n", value);     //6자리 정수. 왼쪽 빈자리 공백
        System.out.printf("상품의 가격: %-6d원\n", value);    //6자리 정수. 오른쪽 빈자리 공백
        System.out.printf("상품의 가격: %06d원\n", value);    //6자리 정수. 왼쪽 빈자리 0 채움

        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n", 10, area);
        //정수 7자리+소수점+소수 2자리. 왼쪽 빈자리 공백

        String name = "청야";
        String job = "프로그래머";
        System.out.printf("%6d | %-10s | %10s\n", 23, name, job);
        /*
        6자리 정수. 왼쪽 빈자리 공백
        10자리 문자열. 오른쪽 빈자리 공백
        10자리 문자열. 왼쪽 빈자리 공백 
        */
    }
}
