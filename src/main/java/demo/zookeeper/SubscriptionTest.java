package demo.zookeeper;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author imnot
 */
public class SubscriptionTest {
	private List<Person> peoples;//前端传入的数据
	private List<Student> students;//后端查询到的数据
	public static  List<Dog> dogs = null;
	public void selectByOpenId() {
		ArrayList<Person> personArrayList = Lists.newArrayList();
		ArrayList<Student> studentArrayList = Lists.newArrayList();
		personArrayList.add(new Person("张三","10",3));
		personArrayList.add(new Person("李四","11",4));
		personArrayList.add(new Person("王五","12",5));
		studentArrayList.add(new Student("张三","13",3));
		studentArrayList.add(new Student("李四","14",4));
		studentArrayList.add(new Student("王五","15",5));
		//1.前端传入的数据有两个 后端没有查询到数据 则全部·进行入库操作
		if (!ObjectUtils.isEmpty(personArrayList)) {
			personArrayList.parallelStream().forEach(
				person -> {
					List<Student> students = studentArrayList.stream().filter(student -> student.getAge().equals(person.getAge())).collect(Collectors.toList());
					if (ObjectUtils.isEmpty(students)) {
						System.out.println("入库操作");
					}else {
						System.out.println("更新操作");
					}
				}
			);
		}else {
			System.out.println("入库");
		}
		//2.前端传入的数据有两个 后端查询到数据 则进行判断 前端的数据如果与查询的数据相等 则更新次数+1 否则执行入库操作

		//3.

	}

	public static void main(String[] args) {
		SubscriptionTest subscriptionTest = new SubscriptionTest();
		subscriptionTest.selectByOpenId();
//		List<String> list =dogs.stream().
//			collect(Collectors.groupingBy(dog->dog.getName(),Collectors.counting()))
//			.entrySet().stream()
//			.filter(entry->entry.getValue()>1)
//			.map(entry->entry.getKey())
//			.collect(Collectors.toList());
//		System.out.println(list.toString());
//		for (int i=1;i<3;i++){
//			for (int j=2;j<4;j++){
//				System.out.println("i*j="+i*j);
//			}
//		}
	}

	class Person{
		private String name;
		private String age;
		private int review;

		public Person(String name, String age, int review) {
			this.name = name;
			this.age = age;
			this.review = review;
		}

		public String getName() {
			return name;
		}

		public Person setName(String name) {
			this.name = name;
			return this;
		}

		public String getAge() {
			return age;
		}

		public Person setAge(String age) {
			this.age = age;
			return this;
		}

		public int getReview() {
			return review;
		}

		public Person setReview(int review) {
			this.review = review;
			return this;
		}
	}

	class Student{
		private String name;
		private String age;
		private int count;

		public Student(String name, String age, int count) {
			this.name = name;
			this.age = age;
			this.count = count;
		}

		public String getName() {
			return name;
		}

		public Student setName(String name) {
			this.name = name;
			return this;
		}

		public String getAge() {
			return age;
		}

		public Student setAge(String age) {
			this.age = age;
			return this;
		}

		public int getCount() {
			return count;
		}

		public Student setCount(int count) {
			this.count = count;
			return this;
		}
	}

	static {
		dogs = new ArrayList<Dog>(){
			{
				add(new Dog("黄一",11));
				add(new Dog("黄一",22));
				add(new Dog("黄三",33));
			}
		};

	}

	static class Dog{
		private String name;
		private int age;


		public Dog(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public Dog setName(String name) {
			this.name = name;
			return this;
		}

		public int getAge() {
			return age;
		}

		public Dog setAge(int age) {
			this.age = age;
			return this;
		}
	}

	public List<Person> getPeoples() {
		return peoples;
	}

	public SubscriptionTest setPeoples(List<Person> peoples) {
		this.peoples = peoples;
		return this;
	}

	public List<Student> getStudents() {
		return students;
	}

	public SubscriptionTest setStudents(List<Student> students) {
		this.students = students;
		return this;
	}

	public static List<Dog> getDogs() {
		return dogs;
	}

	public static void setDogs(List<Dog> dogs) {
		SubscriptionTest.dogs = dogs;
	}

	static class Lists{
		public static <T> ArrayList<T> newArrayList(){
			return new ArrayList<>();
		}
	}
}
