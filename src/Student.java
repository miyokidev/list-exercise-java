public class Student implements Comparable<Student> { // Pas oublier d'implémenter l'interface Comparable
	public String name;
	public int age;
	public int grade;
	
	public Student(String newName, int newAge, int newGrade) {
		this.name = newName;
		this.age = newAge;
		this.grade = newGrade;
	}

	// compareTo() va donc comparer les noms des 2 objects comparés et les trier dans l'ordre alphabétique selon le nom.
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}
	
	
}
