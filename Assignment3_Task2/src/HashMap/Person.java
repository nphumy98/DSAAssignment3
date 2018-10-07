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
    private String name;
    private String phoneNumber;
    private int age;
    
    
    public Person(String name,String phoneNumber, int age)
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.age=age;
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
    
}
