#include<bits/stdc++.h>
using namespace std;

class Search {

public:

	int search(vector<int> arr, int N, int key) {

		int s = 0, e = N - 1;
		int ans = -1;

		while(s <= e) {
			int mid = (s + e) >> 1;

			if(arr[mid] == key) {
				ans = mid;
				break;
			}
			else if(arr[mid]> key) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}

		return ans;
	}

	int lowerBound(vector<int> arr, int N, int key) {

		int s = 0, e = N - 1;
		int ans = -1;

		while(s <= e) {
			int mid = (s + e) >> 1;

			if(arr[mid] == key) {
				ans = mid;
				e = mid - 1;
			}
			else if(arr[mid] > key) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}

		return ans;
	}

	int upperBound(vector<int> arr, int N, int key) {

		int s = 0, e = N - 1;
		int ans = -1;

		while(s <= e) {
			int mid = (s + e) >> 1;

			if(arr[mid] > key) {
				ans = mid;
				e = mid - 1;
			}
			else if(arr[mid] <= key) {
				s = mid + 1;
			}
		}

		return ans;
	}

};


int main() {

	int N, key;
	cin >> N >> key;

	vector<int> arr(N);

	for(int i = 0; i < N; ++i) {
		cin >> arr[i];
	}

	sort(arr.begin(), arr.end());

	Search ob;

	int idx = ob.search(arr, N, key);

	int lb = ob.lowerBound(arr, N, key);

	int ub = ob.upperBound(arr, N, key);

	cout << "Lower Bound of " << key << " is at index " << lb << '\n';

	cout << "Upper Bound of " << key << " is at index " << ub << '\n';

	cout << "Frequency of " << key << " is " << ub - lb << '\n';

	if(idx == -1) {
		cout << "Element not present!\n";
	}
	else if(ub - lb == 1) {
		cout << "Element present at index " << idx << '\n';
	}


	return 0;
}