package problem1002;

import java.util.Vector;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
public class Main
{
			static Vector<String> dupPhones;
			static Hashtable<String, Integer> phoneFreq;
			
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                    phoneFreq = new Hashtable<String, Integer>();
                    dupPhones = new Vector<String>();
                    int n=cin.nextInt();
                    for (int p = 0; p < n; p++) {
						String phone = cin.next();
						
						// convert to normalized phone number
		            	char[] q = new char[7];
		            	for (int i = 0,j=0; i < phone.length(); i++) {
		            		char ch = phone.charAt(i);
								switch (ch)
				         	    {
				         	        case '0': case '1': case '2': case '3': case '4': 
				         		case '5': case '6': case '7': case '8': case '9':
				         		    q[j] = ch; j++; break;
								case 'A': case 'B': case 'C':
									q[j] =  '2'; j++; break;
				         		case 'D': case 'E': case 'F':
				         			q[j] =  '3'; j++; break;
				         		case 'G': case 'H': case 'I':
				         			q[j] =  '4'; j++; break;
				         		case 'J': case 'K': case 'L':
				         			q[j] =  '5'; j++; break;
				         		case 'M': case 'N': case 'O':
				         			q[j] =  '6'; j++; break;
				         		case 'P': case 'R': case 'S':
				         			q[j] =  '7'; j++; break;
				         		case 'T': case 'U': case 'V':
				         			q[j] =  '8'; j++; break;
				         		case 'W': case 'X': case 'Y':
				         			q[j] =  '9'; j++; break;
				         		default:
				         			continue;
				         		}												
						}
		            	
		            	// Earlier I had String.format and it was goddamn slow!
		            	String number =  "" + q[0] + q[1] + q[2] + '-' + q[3] + q[4] + q[5] + q[6];
		            	
		            	Integer i = phoneFreq.get(number);
		            	if (i==null) {
		            		i = 1;            		
		            	}
		            	else {
		            		i = i + 1;
		            		if (i == 2) {
		            			dupPhones.add(number);
		            		}
		            	}
		            	phoneFreq.put(number, i);
		            	
					}
                    
                	Collections.sort(dupPhones);
                	if (dupPhones.size() == 0) {
                		System.out.println("No duplicates.");
                		return;
                	}
                	for (String number : dupPhones) {
    					System.out.printf("%s %d\n", number,phoneFreq.get(number));
    				}
            }            
}