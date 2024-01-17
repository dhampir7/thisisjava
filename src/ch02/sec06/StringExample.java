//문자열 타입
package ch02.sec06;

public class StringExample {
    public static void main(String[] args) {
        String name = "청야";
        String job = "프로그래머";
        System.out.println(name);
        System.out.println(job);

        String str = "나는 \"자바\"를 배웁니다.";    //\"를 사용시 문자열에 큰따옴표를 넣을 수 있다.
        System.out.println(str);

        str = "번호\t이름\t직업";     //\t를 사용시 문자열 간격을 탭만큼 띄워 출력한다.
        System.out.println(str);

        System.out.print("나는\n자바를\n");     //\n를 사용시 출력 후 다음 행으로 이동이 된다.
        System.out.print("배웁니다.");
    }
}