public class Person {

    String name;
    int age;

    /*
        Constructor methods are used to execute some code when an object is created. They are
        often used to initialize fields of the object being created. Any variables we declar
        between the parenthesis of the Constructor declaration are parameters we are expecting
        to be provided when the constructor is called
     */
    public Person(String name, int age){
        /*
            the "this" keyword is used to reference, in this case, the object that is being
            created by the constructor. This allows us to distinguish between the field of
            the object and the parameter that happens to share the same name
         */
        this.name = name;
        this.age = age;
    }

    /*
        This method has a couple of key parts:
        - void: this is the return type declaration. If you are not returning data you use the void keyword
        - greeting: this is the name of the method, we reference it to call the method
        - (): any parameters needed for the method would be declared here
     */
    void greeting(){
        // in this context, "this" is a reference to the object that is calling the method
        // in this case you technically don't need the "this" keyword, but I am adding it to make it explicit what is happening
        System.out.println("Hello! My name is " + this.name + " and I am " + this.age + " years old.");
    }

    void respondToGreeting(){
        System.out.println("Nice to meet you! My name is " + name + " and I am " + age + ".");
    }

    /*
        Anytime you know a method can take in one or more arguments, but you are not sure how many will
        be provided at run time, you can use a vararg. This is a syntax that tells Java one or more arguments
        are going to be provided to the method, but we don't know how many

        Anytime you use varargs it must be the last parameter defined in the method signature
    */

   void countNumbers(int... numbers){
        for(int number : numbers){
            System.out.println(number);
        }
   }


    public static void main(String[] args) {
        // arguments need to be provided in the order the parameters are defined
        Person personOne = new Person("Sally", 34);
        Person personTwo = new Person("Billy", 35);

        /*
            By wrapping the code implementation in methods instead of directly writting the code in main we have a few benefits:
            - The flow of the application is easier to read
            - The code is better organized because code implementation belongs to the class/object the implementation is assocaited with
            - The code is easier to refactor: we just need to update the methods to update the execution of the code
         */
        personTwo.greeting();
        personOne.respondToGreeting();

        personOne.countNumbers(1,2,3,4,5,6,7);

    }

}
