package pt.bmribeiro.javalts.language;

public class NestBasedAccessExample {

    private String secret = "Java 11 Nest-Based Access";

    private static class NestedMember {

        private String readSecret(NestBasedAccessExample example) {
            return example.secret;
        }
    }

    public String accessPrivateMember() {
        NestedMember nested = new NestedMember();
        return nested.readSecret(this);
    }

    public static void main(String[] args) {
        NestBasedAccessExample example = new NestBasedAccessExample();

        System.out.println(example.accessPrivateMember());
    }
}
