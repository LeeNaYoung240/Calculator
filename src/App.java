import java.util.Scanner;

public class App {
    /**
     * Scanner를 사용하여 양의 정수 2개를 전달 받기
     * @param args
     */
    public static void main(String[] args) throws BadInputException {
        /*Sacnner 클래스 객체 생성  */
        //왜 사용? : 매번 입력마다 new Scanner(System.in)아라는 긴 내용을 쓰는건 귀찮음 + 코드 중복으로
        //Scanner 클래스의 객체를 하나 생성해두어 이를 사용하는 것
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int firstNum = 0;
        int secondNum = 0;
        char operator =' ';
        System.out.println("첫 번째 정수를 입력하세요 : ");
        //Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부 확인
        if(sc.hasNextInt()) {
            //첫 번째 정수를 입력 받음
            firstNum = sc.nextInt();
        }
        //정수가 아닐 때
        else{
            //BadInputException 예외 클래스 호출
            throw new BadInputException();
        }
        System.out.println("두 번째 정수를 입력하세요 : ");
        if(sc.hasNextInt()) {
            //두 번째 정수를 입력 받음
            secondNum = sc.nextInt();
        }
        else{ //정수가 아닐 때 BadInputException 예외 클래스 호출
            throw new BadInputException();
        }
        System.out.println("사칙연산 기호를 입력하세요 : ");
        //Scanner 클래스 객체의 sc에 next()를 사용하여 입력 다음에 오는 토큰을 읽음
        //읽어들인 문자열에서 첫 번째 문자를 추출하고 char 타입의 operator 변수에 저장
        operator = sc.next().charAt(0);
        switch(operator) { //사칙연산에 맞게 대입
            case '+': result = firstNum + secondNum; break;
            case '-': result = firstNum - secondNum; break;
            case '*': result = firstNum * secondNum; break;
            case '/': result = firstNum / secondNum; break;
        }
        //연산자가 나눗셈 연산자이고 두 번째 입력받는 수가 0이라면
        if(operator == '/' && secondNum == 0) {
            throw new BadInputException(); //예외 처리
        }
        // 연산자가 +, -, * , / 가 아니라면
        if(operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new BadInputException(); //예외처리
        }
        System.out.println(result);
    }
}