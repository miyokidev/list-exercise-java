/*
 * Ce projet effectue des tests sur les diff�rentes m�thodes demand�s pour le test de Java du Lundi 02.11.2020, il utilise majoritairement
 * des lists d'objects et d�montre diff�rentes situations en expliquant de la mani�re la plus simple possible n'h�sitez pas � me poser des
 * questions si il y a des bouts de code que vous ne comprenez pas.
 * 
 * Made by: Brian Grin
 */
import java.util.*;

public class Program {

	public static void main(String[] args) {
		
		// Initialization
		List<Student> studentList = new ArrayList<Student>(); // Il est mieux de pr�ciser que c'est une liste dans le nom
		List<Integer> gradeList = new ArrayList<Integer>();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		
		// Ajouts d'�l�ments
		gradeList.add(1);
		gradeList.add(2);
		gradeList.add(3);
		gradeList.add(4);
		
		teacherList.add(new Teacher("Bob", 30));
		teacherList.add(new Teacher("Franck", 30));
		teacherList.add(new Teacher("Eric", 30));
		teacherList.add(new Teacher("Jean", 30));
		//-----------------------------------------------------------------------------------------------
		
		// isEmpty() retourne True si la liste est vide et false autrement
		System.out.print("Is the list empty ?: ");
		System.out.println(studentList.isEmpty());
		
		
		if (studentList.isEmpty()) { // On test si la liste est vide si oui on l'a rempli
			System.out.println("filling the list of students");
			studentList.add(new Student("Brian",18,3));
			studentList.add(new Student("Darius",18,3));
			studentList.add(new Student("Thibault",18,3));
			studentList.add(new Student("Georges",18,3));
			studentList.add(new Student("Brian",18,3));
		}
		
		System.out.print("Is the list empty ?: ");
		System.out.println(studentList.isEmpty());
		
		//-----------------------------------------------------------------------------------------------
		
		// contains() retourne True si la liste contient l'object pass� en param�tre et false autrement
		
		// Le code en dessous retourne false car ArrayList impl�mente l'interface List et dans le code source de la m�thode contains,
		// on peut voir qu'il effectue simplement un equals() qui est l'�quivalent d'un == ( Il n'effectue donc pas l'action qu'on
		System.out.println("Premier test contains: " + studentList.contains(new Student("Brian", 18, 3)));
		
		// M�me op�ration qu'au dessus
		System.out.println("Equivalent du premier test: " + studentList.get(0).equals(new Student("Brian", 18, 3)));
		
		// Si on veut pousser plus loin
		System.out.print("Equivalent encore + pouss�: ");
		if (new Student("Brian", 18, 3) == new Student("Brian", 18, 3)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// Le code dessous retourne true car (2 == 2) = true
		System.out.println("Deuxieme test contains: " + gradeList.contains(2));	
		
		//-----------------------------------------------------------------------------------------------
		
		// toArray() Retourne un tableau contenant tout les �l�ments de la liste du premier au dernier
		
		// Si le tableau donn� en param�tres :
		
		// a assez d'espaces => les �l�ments sont stock�s dans le tableau lui-m�me
		// a pas assez d'espaces => un nouveau tableau est cr�e avec le m�me type et taille que la liste donn�
		// a plus d'espaces => il est d'abbord rempli par la liste, puis le reste est �gal � null
		
		// Vous verrez aussi avec cette partie pourquoi je conseille de pr�ciser le type de la variable cela �vite de confondre
		// un array et une liste.
		
		// Le code en dessous ne fonctionne pas car il faut initialiser le tableau d'�l�ve avant
		// Student[] studentArray = studentList.toArray(studentArray);
		
		// Cette m�thode fonctionne
		// Student[] studentArray = {};
		// studentArray = studentList.toArray(studentArray);
		
		// La bonne mani�re est la suivante:
		Student[] studentArray = new Student[studentList.size()];	// Permet d'avoir la m�me taille que la liste
		studentArray = studentList.toArray(studentArray);			// Convertir la liste en tableau
		
		//-----------------------------------------------------------------------------------------------
		
		// Arrays.asList() effectue le processus inverse de la m�thode au dessus => il retourne une liste avec le contenus du tableau.
		
		Student[] studentArray2 = {
				new Student("E",5,5),
				new Student("A",1,1),
				new Student("C",3,3),
				new Student("F",6,6),
				new Student("D",4,4),
				new Student("B",2,2),
		};
		
		// Rien de difficile � comprendre on "converti" le tableau en une liste en transf�rant les �l�ments du tableau dans la liste.
		List<Student> studentList2 = Arrays.asList(studentArray2);
		
		// Affichage
		System.out.println("Before sort: ");
		for (Student s: studentList2) {
			System.out.println(s.name);
		}	
		
		//-----------------------------------------------------------------------------------------------
		
		// Collections.sort() permet de tier les �l�ments de la liste sp�cifi�es dans l'ordre ascendant.
		// Il fonctionne de la m�me mani�re que le Arrays.sort(), en mieux car il peut trier les �l�ments des Arrays, linked list, etc.
		// Mais on connait donc d�j� le fonctionnement de la m�thode �a veut dire il suffit d'impl�menter l'interface Comparable
		// dans la classe du type de la liste qu'on souhaite trier (voir Student.java).
		
		// Si on impl�mente pas Comparable<> on a une erreur au niveau du sort qui dit que la m�thode est pas applicable pour une liste
		// de type Student.
		Collections.sort(studentList2);
		
		// Affichage
		System.out.println("After sort: ");
				for (Student s: studentList2) {
					System.out.println(s.name);
				}	
		
		//-----------------------------------------------------------------------------------------------
	}

}
