import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    //ArrayList 컬렉션 선언, Double타입으로 계산 결과 저장하기 위한 리스트
    private ArrayList<Double> arrList;
    //기본 생성자
    public Calculator() {
        //arrList 생성
        arrList = new ArrayList<>();
    }
    //반환타입을 double형으로 사칙연산 수행
    public double calculate(char operator, int firstNumber, int secondNumber) throws BadInputException {
        double result = 0;
        if(operator!='+' && operator!='-' && operator!='*' && operator!='/') {
            throw new BadInputException("연산자가 아닙니다.");
        }
        if(operator=='+') {
            result = firstNumber + secondNumber;
        }
        else if(operator=='-') {
            result = firstNumber - secondNumber;
        }
        else if(operator=='*') {
            result = firstNumber * secondNumber;
        }
        else if(operator=='/') {
            if(secondNumber == 0) {
                throw new BadInputException("0은 입력될 수 없습니다.");
            }
            result = firstNumber / secondNumber;
        }
        //결과값을 List에 추가
        arrList.add(result);
        //연산 결과값 반환
        return result;
    }
    //Getter 메서드 - arrList 간접 접근 반환
    public List<Double> getArrList() {
        return arrList;
    }
    //Setter 메서드 - arrList 간접 접근 수정
    public void setArrList(ArrayList<Double> arrList){
        this.arrList = arrList;
    }
    //remove 삭제 메서드 - 인덱스 첫 번째 값 삭제
    public void removeResult(){
        arrList.remove(0);
    }

}
