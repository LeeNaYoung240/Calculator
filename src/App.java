import java.util.Scanner;

public class App {
    /**
     * 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산 결과를 저장
     * @param args
     */
    public static void main(String[] args) throws BadInputException {
        //Level1-3
        /*
         *//*Sacnner 클래스 객체 생성  *//*
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
        */

        //Level1-4

      /*  Scanner sc = new Scanner(System.in);

        int result = 0;
        int firstNum = 0;
        int secondNum = 0;
        String operator;

        while (true) {
            System.out.println("첫 번째 정수를 입력하세요 : ");
            if (sc.hasNextInt()) {
                //첫 번째 정수를 입력 받음
                firstNum = sc.nextInt();
            } else {
                // 정수가 아닐 때
                throw new BadInputException();
            }
            System.out.println("두 번째 정수를 입력하세요 : ");
            if (sc.hasNextInt()) {
                // 두 번째 정수를 입력 받음
                secondNum = sc.nextInt();
            } else {
                // 정수가 아닐 때
                throw new BadInputException();
            }
            System.out.println("연산자를 입력하세요 (exit 입력 시 종료) ");
            //Scanner 클래스 객체의 sc에 next()를 사용하여 입력 다음에 오는 토큰을 읽음
            operator = sc.next();
            //operator의 문자열이 exit 일때 종료
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
                    //연산자가 / 일 때 두 번째로 입력받는 수가 0이 아니라면
                    if (secondNum != 0) {
                        //나눗셈
                        result = firstNum / secondNum;
                    } else { //두 번째로 입력받는 수가 0일 때
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                default:
                    //+, -, *, /가 아닌 그 외의 경우
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }
            System.out.println("결과: " + result);
        }*/

        Scanner sc = new Scanner(System.in);

        int[] results = new int[10]; //연산 결과를 저장할 배열
        int firstNum = 0; //첫 번째 입력 정수
        int secondNum = 0; //두 번째 입력 정수
        String operator; //연산자를 저장할 배열
        int index = 0;
        //index가 10이 되기 전까지 무한 반복
        while(index<10){
        System.out.println("첫 번째 정수를 입력하세요 : ");
        //Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부 확인
        if (sc.hasNextInt()) {
            //첫 번째 정수를 입력 받음
            firstNum = sc.nextInt();
        } else {
            // 정수가 아닐 때
            throw new BadInputException();
        }
        System.out.println("두 번째 정수를 입력하세요 : ");
        if (sc.hasNextInt()) {
            // 두 번째 정수를 입력 받음
            secondNum = sc.nextInt();
        } else {
            // 정수가 아닐 때
            throw new BadInputException();
        }
        System.out.println("연산자를 입력하세요 : ");

        operator = sc.next();
        switch (operator) {
            case "+":
                results[index] = firstNum + secondNum;
                break;
            case "-":
                results[index] = firstNum - secondNum;
                break;
            case "*":
                results[index] = firstNum * secondNum;
                break;
            case "/":
                //두 번째 입력 받는 수가 0이 아닐 때 결과 수행
                if (secondNum != 0) {
                    results[index] = firstNum / secondNum;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue; // 다음 반복으로 넘어감
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                continue; // 다음 반복으로 넘어감
            }
            System.out.println("결과 "+(index+1)+" : "+results[index]);
            //인덱스를 증가시켜야 인덱스 번호가 증가
            index++;
        }
    }
}