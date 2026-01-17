import com.podcatcher.Podcast;
/**
 * Assignment: Program 3 | Podcast
 * Instructions: A Podcast system that allows applications to manage podcasts
 * Design Notes: Added constants (final), input validation for Podcast() & setFollowers(), added a test for if a podcast is popular
 * Version: 1.0, 9/15/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class PodcastTestHarness {
	public static void main(String[] args) {
		System.out.println("[SYSTEM MESSAGE] Program Start!\n");
		final int FOLLOWERS_INCREASE_VALUE = 123;
		String[] titles = {"Dateline NBC","Thoughtworks Technology Podcast","The Daily","Things Unseen","Apple News Today"};
		String[] producers = {"NBC News","Thoughtwork","The New York Times","Ligonier Ministries","Apple News"};
		int[] followers = {38000,41,102000,1400,8900};
		boolean[] freeFlags = {false,true,false,true,false};
		Podcast[] podcasts = new Podcast[5];
		for (int index = 0; index < podcasts.length; index++) {
			podcasts[index] = new Podcast(titles[index],producers[index],followers[index],freeFlags[index]);
		}
		for (int index = 0; index < podcasts.length; index++) {
			podcasts[index].setFollowers(podcasts[index].getFollowers() + FOLLOWERS_INCREASE_VALUE);
		}
		for (int index = 0; index < podcasts.length; index++) {
			System.out.println("[SYSTEM MESSAGE] " + podcasts[index].toString());
		}
		System.out.println("\n[SYSTEM MESSAGE] Testing If A Podcast Popular!\n");
		for (int index = 0; index < podcasts.length; index++) {
			System.out.println("[SYSTEM MESSAGE] Podcast: " + podcasts[index].getTitle() + "; Is Podcast Popular: " + podcasts[index].isPopular());
		}
		System.out.println("\n[SYSTEM MESSAGE] Program Terminated...");
	}
}