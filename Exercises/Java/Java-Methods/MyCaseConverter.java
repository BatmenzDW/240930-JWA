import java.util.Arrays;
import java.util.stream.Collectors;

public class MyCaseConverter {
    public static void main(String[] args) {
        String input = "exampleVariableName";
        // String initialCase = "camel";
        String targetCase = "snake_case";

        MyCaseConverter caseConverter = new MyCaseConverter();
        
        String result = caseConverter.convertCase(input, targetCase);
        System.out.println("Converted Variable: " + result);
    }

    public String convertCase(String input, String targetCase) 
    {
        String inputCase = detectCase(input);
        String[] medium;

        if (inputCase == targetCase)
        {
            return input;
        }

        switch (inputCase) {
            case "SCREAMING_SNAKE_CASE":
                medium = splitSnakeInput(input.toLowerCase());
                break;

            case "snake_case":
                medium = splitSnakeInput(input);
                break;

            case "camelCase":
            case "PascalCase":
                medium = splitCamelInput(input);
                break;
        
            default:
                throw new RuntimeException("Unable to determine input's case.");
        }

        switch (targetCase) {
            case "SCREAMING_SNAKE_CASE":
                return convertScreamingSnakeCase(medium);

            case "snake_case":
                return convertSnakeCase(medium);

            case "camelCase":
                return convertCamelCase(medium);

            case "PascalCase":
                return convertPascalCase(medium);
        
            default:
                throw new RuntimeException("Unsupported target case.");
        }

        // implementation goes here
    }

    private String detectCase(String input)
    {
        if (Character.isUpperCase(input.charAt(0)))
        {
            if (input.contains("_")){
                return "SCREAMING_SNAKE_CASE";
            }
            else {
                return "PascalCase";
            }
        }
        else
        {
            if (input.contains("_")){
                return "snake_case";
            }
            else {
                return "camelCase";
            }
        }
    }
    
    private String[] splitSnakeInput(String input)
    {
        return input.split("_");
    }

    private String[] splitCamelInput(String input)
    {
        return Arrays.asList(input.split("(?<!^)(?=[A-Z])")).stream().map(s -> s.toLowerCase()).collect(Collectors.toList()).toArray(new String[0]);
    }

    private String convertSnakeCase(String[] medium)
    {
        return String.join("_", medium);
    }

    private String convertScreamingSnakeCase(String[] medium)
    {
        return convertSnakeCase(medium).toUpperCase();
    }

    private String convertCamelCase(String[] medium)
    {
        StringBuilder sb = new StringBuilder(medium[0]);
        for (int i = 1; i < medium.length; i++)
        {
            String med = medium[i];
            sb.append(Character.toUpperCase(med.charAt(0)));
            sb.append(med.substring(1));
        }
        return sb.toString();
    }

    private String convertPascalCase(String[] medium)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < medium.length; i++)
        {
            String med = medium[i];
            sb.append(Character.toUpperCase(med.charAt(0)));
            sb.append(med.substring(1));
        }
        return sb.toString();
    }
}
