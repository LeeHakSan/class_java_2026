package innerclass;


// 지역 내부 클래스 (Local inner class)
// 잘 안 씀 100에 하나 꼴
// 일회성 사용에 용이
public class OuterClass3 {

    public void display() {
        // 메서드 안에 클래스 선언
        class LocalInnerClass {
            void printMessage() {
                System.out.println("지역 내부 클래스의 메서드");
            }

        }// 지역 내부 클래스

        // 지역 내부 클래스의 인스턴스 생성
        LocalInnerClass innerClass = new LocalInnerClass();
        innerClass.printMessage();

    }


}
