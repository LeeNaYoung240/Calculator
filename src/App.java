import java.util.Scanner;

public class App {

    public static void main(String[] args) throws BadInputException  {
        Scanner sc = new Scanner(System.in);

        int firstNum = 0, secondNum = 0, result = 0;
        String operator;

        while (true) {
            System.out.println("첫 번째 정수를 입력하세요 : ");
            if (sc.hasNextInt()) {
                firstNum = sc.nextInt();
            } else {
                throw new BadInputException("정수가 아닙니다. 정수를 입력하세요.");
            }
            System.out.println("두 번째 정수를 입력하세요 : ");
            if (sc.hasNextInt()) {
                secondNum = sc.nextInt();
            } else {
                throw new BadInputException("정수가 아닙니다. 정수를 입력하세요.");
            }
            System.out.println("연산자를 입력하세요 (exit 입력 시 종료) ");
            operator = sc.next();

            // 문자열의 입력이 exit 일때 종료
            if (operator.equals("exit")) {
                break;
            }
            //연산자에 따라 다른 기능 수행
            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    if (secondNum != 0) {
                        //나눗셈
                        result = firstNum / secondNum;
                    } else {
                        System.out.println("나눗셈을 수행할 때, 두 번째 수는 0이 될 수 없습니다.");
                        continue;
                    }
                    break;

                default:
                    //+, -, *, /가 아닌 그 외의 경우
                    System.out.println("+, -, *, / 해당 연산자만 입력 가능합니다.");
                    continue;
            }
            System.out.println("결과: " + result);
        }
    }
}