// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.Если значение null,
// то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Ответ: "select * from students where name = 'Ivanov' and country = 'Russia' and city = 'Moscow'" для приведенного примера

package HomeWork2;

public class Task2 {
    public static void main(String[] args) {
        String templateQuery = "select * from students where ";
        String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String query = new StringBuilder(templateQuery).append(ParseFilter(jsonFilter)).toString();
        System.out.println(query);
    }

    public static String ParseFilter(String filter) {
        String[] criteries = filter.substring(1, filter.length()-1).split(", ");
        StringBuilder where = new StringBuilder();
        boolean first = true;
        for (String criterion: criteries)  {
            String[] keyValue = criterion.split(":");
            if(!keyValue[1].equals("\"null\"")) {
                if(first)
                    first = false;
                else
                    where.append(" and ");
                where.append(keyValue[0].substring(1, keyValue[0].length() - 1));
                where.append(" = '");
                where.append(keyValue[1].substring(1, keyValue[1].length() - 1));
                where.append("'");
            }
        }
        return where.toString();
    }
}
