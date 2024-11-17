package hw3;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;
	import java.util.Objects;
	import java.util.stream.Collectors;
public class account {

	    public static void main(String[] args) {
	    

	    	Account o1 = new Account("Ali", 5, 1);
	    	Account o2 = new Account("atefe", 1, 1);
	    	Account o3 = new Account("samira", 11, 3);
	    	Account o4 = new Account("kimia", 9, 2);
	    	Account o5 = new Account("kiana", 15, 3);
	    	Account o6 = new Account("arsha", 20, 4);
	    	
	    	
	    	List<Account> ob = new ArrayList<>();
	    	Account[] accounts = {o1, o2, o3, o4, o5, o6};
	    	for (Account account : accounts) {
	    	    ob.add(account);
	    	}
	    	
	    		    	
	    	for (Iterator<Account> iterator = ob.iterator(); iterator.hasNext();) {
				Account account = (Account) iterator.next();
				System.out.println(account.toString());
			}
	    	
	    	
	    	
	    	Collections.sort(ob, new Comparator<Account>() {
				@Override
				public int compare(Account a, Account b) {
					return a.getBalance() - b.getBalance();
				}
	    	});

	    	System.out.println();
	    	
	    	for (Account account : ob) {
	            System.out.println(account.getName() + " : " + account.getBalance());
	        }

	    	System.out.println();
	    	
	    	Collections.sort(ob, new Comparator<Account>() {
				@Override
				public int compare(Account a, Account b) {
					return a.getBalance() - b.getBalance();}}.reversed());
	    	
	    	for (Account account : ob) {
	            System.out.println(account.getName() + " : " + account.getBalance());
	        }
	    	
	        		
	    	Map<String, Account> mapp = new HashMap<>();
	    	mapp.put("o1", o1);
	    	mapp.put("02", o2);
	    	mapp.put("o3", o3);
	    	mapp.put("o4", o4);
	    	mapp.put("o5", o5);
	    	
	    	for (Map.Entry<String, Account> entry : mapp.entrySet()) {
				String key = entry.getKey();
				Account val = entry.getValue();
				System.out.println(key + " : " + val);
			}

	    	
	    	List<String> rmv = mapp.entrySet().stream()
	    			.filter(t -> t.getValue().getBranch() == 2)
	    			.map(t -> t.getKey()).toList();
	    	
	    	for (Iterator<String> iterator = rmv.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				mapp.remove(string);
			}
	    	
	    	System.out.println(mapp);
	    	
	    	
	    	List<String> name = ob.stream()
	    			.filter(t -> t.getName().startsWith("A"))
	    			.map(t -> t.getName())
	    			.collect(Collectors.toList());
	    	
	    	System.out.println(name);		
	    	
	    	System.out.println();
	    	
	    	List<String> nameuper = ob.stream()
	    			.map(t -> t.getName().toUpperCase())
	    			.collect(Collectors.toList());
	    	System.out.println(nameuper);
	    	
	    	System.out.println();
	    	
	    	List<String> namebalance = ob.stream()
	    			.filter(t -> t.getName().startsWith("A") && t.getBalance() > 10)
	    			.map(t -> t.getName())
	    			.collect(Collectors.toList());
	    	System.out.println(namebalance);
	    	
	    }
	}

	class Account {
	    private String name;
	    private int balance;
	    private int branch;
	    

	    @Override
		public int hashCode() {
			return Objects.hash(balance);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			return balance == other.balance;
		}

		public Account(String name, int balance, int branch) {
	        this.name = name;
	        this.balance = balance;
	        this.branch = branch;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getBalance() {
	        return balance;
	    }

	    public int getBranch() {
	        return branch;
	    }

	    public void setName(String name) {
			this.name = name;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		public void setBranch(int branch) {
			this.branch = branch;
		}

		@Override
	    public String toString() {
	        return "Account{" +
	                "name='" + name + '\'' +
	                ", balance=" + balance +
	                ", branch='" + branch + '\'' +
	                '}';
	    }
	}
