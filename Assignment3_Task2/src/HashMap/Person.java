/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

/**
 *
 * @author jimmynguyen
 */
public class Person {
    private String name; //attribute represent value however to generateHashCode for Key
    private String phoneNumber; //attribute represent value
    private int age; //attribute represent value
    private long key;
    
    //constructor
    public Person(String name,String phoneNumber, int age)
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.age=age;
        this.key= this.generateHashCode();
    }
    
    public Person(String name)
    {
        this.name=name;
        this.phoneNumber="000";
        this.age=20;
        this.key= this.generateHashCode();
    }
    
    //generate hash code function which provide hashKey for Person Object
    public long generateHashCode() //provide hash code (or Key)
    {
        char[] nameCharacter= this.name.toCharArray();
        long hashKey=0;
        for(int i=0;i<nameCharacter.length;i++)
        {
            int value= nameCharacter[i];
            hashKey+=value;
        }
        return hashKey;
    }
    
    //toString
    @Override    
    public String toString() {
        return "Person{" + "name=" + name + ", key=" + key + '}';
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    //compare 2 Key of 2 Person object
    public boolean compareTo(Person anotherPerson)
    {
        return (this.key==anotherPerson.key);
    }
}
