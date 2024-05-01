import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//추상 클래스 - 객체 직접 생성 X, 상속을 통해 하위 클래스에서 기능 확장하고 구현
public abstract class Calculator {
    //ArrayList 컬렉션 선언, Double 타입으로 사칙연산 계산 결과 저장하기 위한 리스트
    public ArrayList<Double> arrList;
    // 추상 클래스에서 공통 동작 정의, 하위 클래스에서 구체화하여 각각의 동작 구현
    //calculate() 추상 메서드 선언 - 하위 클래스에서 해당 메서드 반드시 구현
    public abstract double calculate() throws BadInputException;
    // setArrList() 추상 메서드 선언, 하위 클래스에서 반드시 구현
    public abstract void setArrList();
    //getArrList() 추상 메서드 선언, 하위 클래스에서 반드시 구현
    public abstract List<Double> getArrList();



    /*
    //ArrayList 컬렉션 선언, Double 타입으로 사칙연산 계산 결과 저장하기 위한 리스트
    private ArrayList<Double> arrList;
    //Double 타입으로 원의 넓이 저장하기 위한 컬렉션
    private  ArrayList<Double> circleList;


    //연산결과를 저장하기 위한 리스트 초기화
    public Calculator(ArrayList<Double> arrList, ArrayList<Double> circleList) {
        this.arrList = arrList;
        this.circleList = circleList;
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
    public void inquiryResults() {
        for(Double val : arrList)
        {
            System.out.println(val);
        }
        for(Double area : circleList)
        {
            System.out.println(area);
        }
    }
    public double calculateCircleArea(int radius)
    {
        // Math.PI에서 PI가 public static final double PI = 3.14159265358979323846;로 선언되어있기 때문에
        //static final로 따로 선언하지 않았음
        double area = radius*radius*Math.PI;
        circleList.add(area);
        return area;
    }
    //Getter 메서드 - getCircleAreaList 간접 접근 반환
    public List<Double> getCircleAreaList() {
        return circleList;
    }
    //Setter 메서드 - setCircleAreaList 간접 접근 수정
    public void setCircleAreaList(ArrayList<Double> circleAreaList) {
        this.circleList = circleAreaList;
    }*/

}
