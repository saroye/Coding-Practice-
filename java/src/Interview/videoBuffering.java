package Interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 *  Netflix sends n packets that arrives at: "arrivalRate" packets per second.
 *  packets do not arrive one at a time. 
 *  
 *  video buffers or plays based on these conditions:
 *  
 *  1.	video player plays one packet per second in numerical order 
 *  	of packet number starts 1 at time t =1
 *  
 *  2.	packet may be used in future are stored in buffer.
 *  	while ones already played are discarded. packets may be resent/duplicated (are ignored)
 *  
 *  3. 	video player "re-buffer" whenever the correct packet is nto immediately available
 *  	either from buffer or first element received at that time from data stream
 *  
 *  4. if multiple packets arrive at a particular second t,
 *  	only first packet is played and remainign packets will be buffered or ignored.
 *  
 *  find first time at whch the video begins re-buffering. if it is never necessary, return -1; 
 *  video ends after end of array is reached.
 *  1,3,1,2,3,2,4,3
 * @author Saroye
 *
 */
public class videoBuffering {
	
	public int videoBuffer(int[] packets, int arrivalRate) {

		int Buffer_size=arrivalRate,
			buffer_counter=1,
			last_buffer=0;
		boolean buffer_good=true;
			//packet_played=0, 
			//cur_buffer=0;
		
		Queue<Integer> buffer= new LinkedList<Integer>();
		for(int i=0; i<arrivalRate; i++) {
			buffer.add(packets[i]);
		}
		Buffer_size=(Buffer_size+arrivalRate)-1;
		Queue<Integer> nxt_buffer=this.updateBuffer(packets, buffer, arrivalRate, Buffer_size, buffer.peek());
		int len=(packets.length-1)/arrivalRate;
		
		for(int i=0; i<len; i++) {
			System.out.println("Packet: "+i+" : ");
			for(int j=0; j<arrivalRate; j++) {
				//System.out.println("buffer size: "+buffer.size());
				if(buffer.peek()==buffer_counter) {
					buffer_good=true;
					last_buffer=buffer.peek();
					System.out.println(buffer.poll()+" ");
					buffer_counter++;
				}
				else {
					buffer_good=false;
				}
			}
			if(buffer_good==false) {
				if(nxt_buffer.peek()==last_buffer+1) {
					System.out.println("Next from packets: "+packets[Buffer_size]);
					buffer_counter++;
				}
				else {
					System.out.println("Re-buffering at: "+buffer.peek() );
					//return buffer.peek();
				}
			}
			else {
				System.out.println("buffer_counter: "+buffer_counter);
				buffer=this.updateBuffer(packets, buffer,arrivalRate,Buffer_size,last_buffer);
			
				Buffer_size=(Buffer_size+arrivalRate)-1;
			}
			System.out.println("Packet: "+i+" has been completed!");
		}
		return -1;
	}
	
	public Queue<Integer> updateBuffer(int[] packets, Queue<Integer> old_buffer, int arrivalRate, int count, int last) {
		
		if(old_buffer.isEmpty()) {
			
			for(int i=count;i<packets.length; i++) {
				if( old_buffer.size()<arrivalRate) {	
					if(packets[i]>last) {
						//System.out.println("coming? "+i);
						old_buffer.add(packets[i]);
					}
				}
				else {
					System.out.print("Buffer: ");
					for(int j : old_buffer) {
						System.out.print(j+ " ");
					}
					System.out.println();
					return old_buffer;
				}
			}
		}
		return old_buffer;
	}
	
	public static void main(String[] args) {
		
		videoBuffering v = new videoBuffering();
		int[] buffer= {1,3,1,2,2,3,3,4};
		System.out.println("PACKETS: "+Arrays.toString(buffer));
		System.out.println(v.videoBuffer(buffer, 1));
		
	}

}
