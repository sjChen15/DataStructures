
public class HashTest{
	public static void main(String[] args){
		HashTable<String> names = new HashTable<String>();
		names.add("Leo");
		names.add("Gary");
		names.add("Luka");
		names.add("Alex");
		names.add("Jasnoor");
		names.add("Musbah");
		names.add("Robin");
		System.out.println(names);
		names.remove("Jasnoor");
		System.out.println(names);
		int alexHash = "Alex".hashCode();
		System.out.println(names.getH(alexHash));
		System.out.println(names.getLoad());
		System.out.println(names);
		names.setLoad(.1);
		System.out.println(names.getLoad());
		System.out.println(names.toArray());
		
	}
}
