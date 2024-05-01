import java.util.Scanner;

public class App {

    public static void main(String[] args) throws BadInputException  {
        Scanner sc = new Scanner(System.in);

        int firstNum = 0, secondNum = 0, result = 0;
        char operator =' ';

        System.out.println("첫 번째 정수를 입력하세요 : ");
        //Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부 확인
        if(sc.hasNextInt()) {
            firstNum = sc.nextInt();
        }
        else{
            //정수가 아닐 때 BadInputException 예외 클래스 호출
            throw new BadInputException("정수가 아닙니다. 정수를 입력하세요.");
        }
        System.out.println("두 번째 정수를 입력하세요 : ");
        if(sc.hasNextInt()) {
            secondNum = sc.nextInt();
        }
        else{
            //정수가 아닐 때 BadInputException 예외 클래스 호출
            throw new BadInputException("정수가 아닙니다. 정수를 입력하세요.");
        }
        System.out.println("사칙연산 기호를 입력하세요 : ");

        operator = sc.next().charAt(0);
        switch(operator) {
            case '+': result = firstNum + secondNum; break;
            case '-': result = firstNum - secondNum; break;
            case '*': result = firstNum * secondNum; break;
            case '/': result = firstNum / secondNum; break;
        }
        //연산자가 나눗셈 and 두 번째 입력받는 수가 0이라면
        if(operator == '/' && secondNum == 0) {
            throw new BadInputException("나눗셈을 수행할 때, 두 번째 수는 0이 될 수 없습니다."); //예외 처리
        }
        // 연산자가 +, -, * , / 가 아니라면
        if(operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new BadInputException("+, -, *, / 해당 연산자만 입력 가능합니다."); //예외처리
        }
        System.out.println(result);
    }
}