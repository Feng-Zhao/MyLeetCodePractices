package  selfPractice.searching;


class BinarySearch {
//    public static binarySearch instance;
//    public binarySearch(){
//        if (instance == null) {
//            binarySearch.instance = new binarySearch();
//            return binarySearch.instance;
//        } else {
//            return binarySearch.instance;
//        }
//    }
    public int search(int[] data, int target){
        if(data.length == 0){
            return Integer.MIN_VALUE;
        }
        else{
            int left = 0;
            int right = data.length - 1;
            int mid = left + (right - left)/2;

            while(left <= right){
                if(data[mid] == target){
                    return mid;
                }
                else if(data[mid] > target){
                    right = mid + 1;
                }
                else if(data[mid] < target){
                    left = mid - 1;
                }
                mid = left + (right - left)/2;
            }
            return Integer.MIN_VALUE;
        }
    }

}