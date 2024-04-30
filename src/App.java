import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws BadInputException {
        //Calculator 클래스의 객체를 생성하여 해당 객체 참조
        Calculator calculator = new Calculator();
        //Scanner 클래스 객체 sc를 생성
        Scanner sc = new Scanner(System.in);
        char operator = ' ';
        int firstNum = 0;
        int secondNum = 0;
        String input = "";
        while (true) {
            try {

                System.out.println("첫 번째 수를 입력하세요 : ");
                //Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부 확인
                if (sc.hasNextDouble()) {
                    //첫 번째 정수를 입력 받음
                    firstNum = sc.nextInt();
                }
                //정수가 아닐 때
                else {
                    //BadInputException 예외 클래스 호출
                    throw new BadInputException("정수가 아닙니다.");
                }

                System.out.println("두 번째 수를 입력하세요 : ");
                if (sc.hasNextDouble()) {
                    //두 번째 정수를 입력 받음
                    secondNum = sc.nextInt();
                }
                //수가 아닐 때
                else {
                    //BadInputException 예외 클래스 호출
                    throw new BadInputException("수가 아닙니다.");
                }

                System.out.println("연산자를 입력하세요 : ");
                operator = sc.next().charAt(0);
                //연산자가 나눗셈 연산자이고 두 번째 입력받는 수가 0이라면
                if (operator == '/' && secondNum == 0) {
                    throw new BadInputException(); //예외 처리
                }
                // 연산자가 +, -, * , / 가 아니라면
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    throw new BadInputException(); //예외처리
                }
                //calculator 변수가 참조하는 Calculator 객체의 calculate 메서드 호출
                System.out.println("결과 : " + calculator.calculate(operator, firstNum, secondNum));
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                input = sc.next();
                if(input.equals("exit")) {break;}
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
            }
        }


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
        //level.1-6
/*

        Scanner sc = new Scanner(System.in);

        int[] results = new int[10]; // 연산 결과를 저장할 배열
        int firstNum = 0; // 첫 번째 입력 정수
        int secondNum = 0; // 두 번째 입력 정수
        String operator; // 연산자를 저장할 변수
        int index = 0; // 결과 배열 인덱스
        int result = 0; // 계산된 결과를 저장할 변수

// index가 10이 되기 전까지 무한 반복
        while (true) {
            System.out.println("첫 번째 정수를 입력하세요: ");
            // Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부를 확인
            if (sc.hasNextInt()) {
                // 첫 번째 정수를 입력 받음
                firstNum = sc.nextInt();
            } else {
                // 정수가 아닐 때
                throw new BadInputException();
            }
            System.out.println("두 번째 정수를 입력하세요: ");
            if (sc.hasNextInt()) {
                // 두 번째 정수를 입력 받음
                secondNum = sc.nextInt();
            } else {
                // 정수가 아닐 때
                throw new BadInputException();
            }
            System.out.println("연산자를 입력하세요: ");

            operator = sc.next();
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
                    // 두 번째 입력 받는 수가 0이 아닐 때 결과를 수행
                    if (secondNum != 0) {
                        result = firstNum / secondNum;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue; // 다음 반복으로 넘어감
                    }
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue; // 다음 반복으로 넘어감
            }
            // 배열에 결과값을 저장시키고 인덱스를 증가시킴
            results[index] = result;
            index++;

            // 배열의 인덱스 값이 10을 초과하는 경우일 때
            if (index >= 10) {
                //배열의 결과를 한칸씩 앞으로 이동
                for (int i = 0; i < results.length - 1; i++) {
                    results[i] = results[i + 1];
                }
                // 새로운 결과는 마지막 인덱스에 저장
                results[9] = result;
                // 인덱스가 9가 되면 다음 결과가 마지막 위치에 저장
                index = 9; // 인덱스를 9로 설정
            }

            // 결과 출력
            System.out.println("결과: ");
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ": " + results[i]);
            }

            // 해당 안내메세지 출력
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            // 사용자로부터 문자열 한 줄을 입력 받음
            // 왜 ? : 더 계산하겠냐는 질문에 대답을 받기 위해,

            operator = sc.next();
            // exit 입력시 종료
            if (operator.equals("exit")) {
                break;
            }
        }*/
        //level1-7

      /*  Scanner sc = new Scanner(System.in);
        int firstNum = 0; //첫 번째 입력 정수
        int secondNum = 0; //두 번째 입력 정수
        String operator; //연산자를 저장할 배열
        //동적 배열로 크기가 가변적으로 늘어날 때 사용하는 리스트
        ArrayList<Integer> result = new ArrayList<>();
        //Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부 확인
        while(true) {
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
            System.out.println("연산자를 입력하세요 : ");
            //연산자를 입력하기 위해 사용자로부터 한 줄을 입력 받음
            operator = sc.next();
            int results =0;
            switch (operator) {
                case "+":
                    result.add(firstNum + secondNum);
                    break;
                case "-":
                    result.add(firstNum - secondNum);
                    break;
                case "*":
                    result.add(firstNum * secondNum);
                    break;
                case "/":
                    //연산자가 / 일 때 두 번째로 입력받는 수가 0이 아니라면
                    if (secondNum != 0) {
                        //결과 수행
                        result.add(firstNum / secondNum);
                    } else { //두 번째로 입력받는 수가 0일 때
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                default:
                    //+, -, *, /아닌 그 외의 경우 처음부터 계속 진행
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }

            System.out.println("결과: " + result);
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            //해당 입력 메세지에 대한 결과를 사용자로부터 입력받음
            operator = sc.next();
            //remove 문자열을 입력했을 경우
            if(operator.equals("remove"))
            {
                //result 리스트의 값이 존재한다면
                if(!result.isEmpty())
                {
                    //result 리스트의 첫 번째 인덱스 값을 삭제
                    int removeResult = result.remove(0);
                    System.out.println("가장 먼저 저장된 결과인 "+removeResult+"가 삭제되었습니다.");
                }
                //result 리스트의 값이 존재하지 않는다면
                else{
                    System.out.println("저장된 결과가 없습니다.");
                }
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            //해당 입력 메세지에 대한 결과를 사용자로부터 입력받음
            operator = sc.next();
            //문자열 exit가 입력됐을 경우 종료
            if(operator.equals("exit"))
            {
                break;
            }
        }*/
        //level1-8

       /* Scanner sc = new Scanner(System.in);
        int firstNum = 0; //첫 번째 입력 정수
        int secondNum = 0; //두 번째 입력 정수
        String operator; //연산자를 저장할 배열
        //동적 배열로 크기가 가변적으로 늘어날 때 사용하는 리스트
        ArrayList<Integer> result = new ArrayList<>();
        //Scanner 클래스의 sc 객체의 hasNextInt() 메서드는 다음 토큰이 정수인지 여부 확인
        while(true) {
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
            System.out.println("연산자를 입력하세요 : ");
            //연산자를 입력하기 위해 사용자로부터 한 줄을 입력 받음
            operator = sc.next();
            int results = 0;
            switch (operator) {
                case "+":
                    result.add(firstNum + secondNum);
                    break;
                case "-":
                    result.add(firstNum - secondNum);
                    break;
                case "*":
                    result.add(firstNum * secondNum);
                    break;
                case "/":
                    //연산자가 / 일 때 두 번째로 입력받는 수가 0이 아니라면
                    if (secondNum != 0) {
                        //결과 수행
                        result.add(firstNum / secondNum);
                    } else { //두 번째로 입력받는 수가 0일 때
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                default:
                    //+, -, *, /아닌 그 외의 경우 처음부터 계속 진행
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }

            System.out.println("결과: " + result);
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            //해당 입력 메세지에 대한 결과를 사용자로부터 입력받음
            operator = sc.next();
            //remove 문자열을 입력했을 경우
            if (operator.equals("remove")) {
                //result 리스트의 값이 존재한다면
                if (!result.isEmpty()) {
                    //result 리스트의 첫 번째 인덱스 값을 삭제
                    int removeResult = result.remove(0);
                    System.out.println("가장 먼저 저장된 결과인 " + removeResult + "가 삭제되었습니다.");
                }
                //result 리스트의 값이 존재하지 않는다면
                else {
                    System.out.println("저장된 결과가 없습니다.");
                }
            }
            System.out.println("저장된 연산결과를 조회하겠습니까? (inquiry 입력 시 조회)");
            //입력 안내 메시지에 대한 결과를 사용자로부터 입력 받음
            operator = sc.next();
            //문자열 inquiry를 입력했을 때 확장 for문 사용
            if(operator.equals("inquiry"))
            {
                //for(타입 변수명 : 콜렉션 명)
               for(Integer val : result)
               {
                   System.out.print(val+" ");
               }
                System.out.println();
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            //해당 입력 메세지에 대한 결과를 사용자로부터 입력받음
            operator = sc.next();
            //문자열 exit가 입력됐을 경우 종료
            if (operator.equals("exit")) {
                break;
            }
        }*/
    }
}