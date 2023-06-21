package com.streampractical.player;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student
{
  String name;
  int marks;
  Student(String name,int marks){
    this.name = name;
    this.marks = marks;
  }
}
public class Main {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<Student>();
    studentList.add(new Student("Kiva",78));
    studentList.add(new Student("Manishi",23));
    studentList.add(new Student("Dev",35));
    studentList.add(new Student("Kush",54));
    studentList.add(new Student("Mitansh",55));
    studentList.add(new Student("Ritvika",21));
    studentList.add(new Student("Kiean",77));
    studentList.add(new Student("Harsh",87));
    studentList.add(new Student("Archit",31));
    studentList.add(new Student("Shiv",33));


    //Sum of integer
    List <Integer> list = Arrays.asList(1,3,55,22,55,88);
    final Integer integer = list.stream().reduce((a, b) -> a + b).get();
    System.out.println("Sum of Integer" +integer);

    final Integer integer1 = studentList.stream().map(e -> e.marks).reduce((a, b) -> (a + b)).get();
    System.out.println("SUM OF Marks " +integer1);

    List<String> l2 = Arrays.asList("1","5","23","432","22");
    //Average of mumber
    final OptionalDouble average = list.stream().mapToInt(e -> e).average();
    System.out.println("Average of list "+average.getAsDouble());

    List<String> l3 = List.of("2","3","10","15","20");

    final OptionalDouble average1 = l3.stream().map(e -> Integer.parseInt(e)).map(e -> e * e).filter(e -> e < 100).mapToInt(e -> e).average();
    System.out.println(average1.getAsDouble());


    final List<Integer> collect1 = l3.stream().filter(e -> Integer.parseInt(e) % 2 != 0).map(e -> Integer.parseInt(e)).map(e -> e * e).collect(Collectors.toList());
    System.out.println(collect1);

    List<Integer> numbers = List.of(2,23,434,222,545,5435,454,2987);

    final List<String> collect3 = numbers.stream().map(l -> String.valueOf(l)).filter(l -> l.startsWith("2")).collect(Collectors.toList());
    System.out.println(collect3);

    final List<String> collect2 = studentList.stream().map(i -> String.valueOf(i.marks)).filter(i -> i.startsWith("5")).collect(Collectors.toList());
    System.out.println("STrat with 5 "+collect2);
//

    //find duplicate value in list
    List<Integer> l = List.of(1,4,6,1,8,6,4,4,4,4,4);
    final Set<Integer> collect4 = l.stream().filter(e -> Collections.frequency(l, e) == 1).collect(Collectors.toSet());
    System.out.println(collect4);


    List <String> salary = List.of("23","a66","12","43","11");
//        final String s1 = salary.stream().max(Comparator.comparing(Integer::valueOf)).get();

    final String s2 = salary.stream().max((a1, a2) -> a1.compareTo(a2)).get();
    System.out.println(s2);
//        final OptionalDouble average1 = l.stream().mapToInt(e -> Integer.parseInt(e)).average();
//        System.out.println("Average of String data type"+average1);
//
//
//        final Optional<String> first = studentList.stream().map(i -> i.name).sorted((e1, e2) -> e2.length() - e1.length()).findFirst();
//        System.out.println(first.get());
//
//        final Map<String, Long> collect1 = studentList.stream().map(i -> i.name).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        final OptionalInt max = studentList.stream().mapToInt(i -> Integer.parseInt(String.valueOf(i.name.length()))).max();
//        System.out.println(max);
//        System.out.println(collect1);

//        final Map<Integer, List<String>> collect = studentList.stream().map(i -> i.name).collect(Collectors.groupingBy(i -> i.length())).entrySet().stream();
//        System.out.println(collect);


//        List<String> passStudentname = studentList.stream().filter(s->s.marks>35).map(s->s.name).collect(Collectors.toList());
//        System.out.println(passStudentname);
//
    String s = "hello i am arpit . hello i am parth y";
//            for()
//        String[] split =  s.split("");

//        List<String> l = List.of(s.split(""));
////        System.out.println(Arrays.toString(split));
//        Map<String ,List<String>> map =  l.stream().collect(Collectors.groupingBy(y->y));
//        System.out.println(map);
//
//
//        //find each char occcurance
//        Map<String, Long> collect = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);
//
//        //find duplicate element from a given string
//        final List<String> duplicate = m.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
//
//        System.out.println(duplicate);

//

//        final List<String> collect2 = studentList.stream().map(K -> K.name).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(collect2);



    final List<Character> collect = studentList.stream().flatMap(i -> i.name.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());
    System.out.println(collect);
//
//
//        final List<String> unique = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(unique);
//
////FIRST NON REPEAT ELEMENT
//       String firstNonRepeatElement =  l.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
//                .filter(x->x.getValue() == 1).findFirst().get().getKey();
//        System.out.println(firstNonRepeatElement);
//
//        //FIRST REPEAT ELEMENT
//        final String key = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(x -> x.getValue() > 1).findFirst().get().getKey();
//        System.out.println(key);
//
//
//       int[] num = {3,546,32,5,2,444};
//        Integer integer =  Arrays.stream(num).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//        System.out.println(integer);;


  }

}