package example.spring.DI.util;

public class VersionPrinter {

    private int majorVersion;
    private int minorVersion;

    public void print() {
        System.out.printf("이 프로그램의 버전은 %d.%d 입니다. \n\n", majorVersion, minorVersion);
    }

    // int,long과 같은 기본 데이터 타입과 String 타입의 값은 일반 코드처럼 값을 설정하면 된다.
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }
}
