package innerclass;

public class SpaceShipMain {

    public static void main(String[] args) {

        // 정적 내부 클래스라서 바로 생성 가능함
        SpaceShip.Engine engine1 = new SpaceShip.Engine();
        SpaceShip spaceship = new SpaceShip();
        spaceship.addEngine(engine1);
        spaceship.startSpaceShip();

    } // end of main
}
