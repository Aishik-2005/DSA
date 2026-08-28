#include <stdbool.h>

bool canJump(int* nums, int numsSize) {
    int maxReach = 0;

    for (int i = 0; i < numsSize; i++) {
        if (i > maxReach) {
            return false;  // can't even reach index i
        }
        int reachFromHere = i + nums[i];
        if (reachFromHere > maxReach) {
            maxReach = reachFromHere;
        }
    }

    return true;
}