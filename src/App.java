import java.util.Scanner;

public class App {
    /**
     * Scanner를 사용하여 양의 정수 2개를 전달 받기
     * @param args
     */
    public static void main(String[] args) {
        /*Sacnner 클래스 객체 생성  */
        //왜 사용? : 매번 입력마다 new Scanner(System.in)아라는 긴 내용을 쓰는건 귀찮음 + 코드 중복으로
        //Scanner 클래스의 객체를 하나 생성해두어 이를 사용하는 것
        Scanner sc = new Scanner(System.in);

        //입력 메세지 출력
        System.out.println("첫 번째 숫자를 입력하세요 : ");
        //Scanner 클래스의 객체인 sc를 사용하여 양의 정수를 firstNum 변수에 입력 받음
        int firstNum = sc.nextInt();
        //입력 메세지 출력
        System.out.println("두 번째 숫자를 입력하세요 : ");
        //Scanner 클래스의 객체인 sc를 사용하여 양의 정수를 secondNum 변수에 입력 받음
        int secondNum = sc.nextInt();

    }
}