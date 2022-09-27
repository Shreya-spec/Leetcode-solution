class Solution {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int l = 0;
		int r = n-1;
		int ans = 0;
		while(l<=r) {
			int mid = l + (r-l)/2;
			if(citations[mid]>=(n-mid) && (mid-l+1)<=citations[mid]) {
				// we save the first finding, but we keep looking for possible bigger answer
				ans = n-mid;
				r = mid-1;
			}
			else if(citations[mid]<(n-mid))
				l = mid+1;
			else
				r = mid-1;
		}
		return ans;
	}
}