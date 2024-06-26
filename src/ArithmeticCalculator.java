import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ArithmeticCalculator 클래스는 Calculator 클래스를 상속받은 클래스
public class ArithmeticCalculator extends Calculator {

    private AddOperator addOperator;
    private SubtractOperator subtractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;

    /*사칙연산 변수*/
    private int firstNum;
    private int secondNum;
    private char operator;

    //Setter 메서드 - 객체의 필드를 설정
    public void setVal(int firstNum, int secondNum, char operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }

    public ArithmeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator) {
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
    }


    //Getter 메서드 - arrList 리스트를 반환하여 외부에서 해당 리스트에 접근할 수 있도록 허용
    public List<Double> getArrList() {
        return arrList;
    }

    //결과를 저장하는 리스트 초기화
    //왜 초기화? : 원의 넓이, 사칙연산 2가지 결과를 저장하는 리스트
    //초기화하지 않으면 이전에 계산된 결과가 남아있음
    @Override
    public void resetList() {
        arrList = new ArrayList<>();
    }

    //사칙연산 수행
    public double calculate() throws BadInputException {
        double result = 0;
        if(operator!='+' && operator!='-' && operator!='*' && operator!='/') {
            throw new BadInputException("연산자가 아닙니다.");
        }
        if(operator=='+') {
            result = addOperator.operate(firstNum, secondNum);
        }
        else if(operator=='-') {
            result = subtractOperator.operate(firstNum, secondNum);
        }
        else if(operator=='*') {
            result = multiplyOperator.operate(firstNum, secondNum);
        }
        else if(operator=='/') {
            if(secondNum == 0) {
                throw new BadInputException("0은 입력될 수 없습니다.");
            }
            result = divideOperator.operate(firstNum, secondNum);
        }
        arrList.add(result);
        return result;
    }
}

