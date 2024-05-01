import java.util.ArrayList;
import java.util.List;
// CircleCalculator 클래스는 Calculator 클래스를 상속받은 클래스
public class CircleCalculator extends Calculator  {
    //반지름 변수 선언
    private int radius;
    //Setter 메서드 - 객체의 필드를 설정
    public void setVal(int radius) {
        this.radius = radius;
    }
    //Getter 메서드 - arrList 리스트를 반환하여 외부에서 해당 리스트에 접근할 수 있도록 허용
    public List<Double> getArrList() {
        return arrList;
    }
    //원의 넓이 구하기
    public double calculate() throws BadInputException
    {
        // Math.PI에서 PI가 public static final double PI = 3.14159265358979323846;로 선언되어있기 때문에
        //static final로 따로 선언하지 않았음
        double area = radius*radius*Math.PI;
        arrList.add(area);
        return area;
    }
    //결과를 저장하는 리스트 초기화
    //왜 초기화? : 원의 넓이, 사칙연산 2가지 결과를 저장하는 리스트
    //초기화하지 않으면 이전에 계산된 결과가 남아있음
    @Override
    public void setArrList() {
        //ArrayList 객체를 초기화하여 arrList에 할당
        arrList = new ArrayList<>();
    }
}
