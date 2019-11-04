package files;

public class PayLoad {

    public static String getPostData(){
        String body = "{\n" +
                "    \"location\":{\n" +
                "        \"lat\" : -38.383494,\n" +
                "        \"lng\" : 33.427362\n" +
                "    },\n" +
                "    \"accuracy\":50,\n" +
                "    \"name\":\"Frontline house\",\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "    \"language\" : \"French-IN\"\n" +
                "}\n";
        return body;
    }

    public static String addBook(String isbn, String aisle){
        String a = "{\n" +
        "\t\"name\" : \"Learn2\",\n" +
                "\t\"" + isbn + "\" : \"sdfsdfsdf2\",\n" +
                "\t\"" + aisle + "\" : \"2272\",\n" +
                "\t\"author\" : \"John2\"\n" +
                "}";
        return a;
    }

}
