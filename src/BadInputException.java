public class BadInputException extends Exception {
    public BadInputException() {
        super("잘못된 입력입니다. ");
    }
    public BadInputException(String message) {
        super(message);
    }
}
