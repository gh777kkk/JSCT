function solution(clothes) {
  return Object.values(clothes.reduce((clothTypeCount,cloth) => {
      var clothType = cloth[1];
      clothTypeCount[clothType] = clothTypeCount[clothType] ? clothTypeCount[clothType] + 1 : 1;
      return clothTypeCount;
  }, {})).reduce((previousValue, currentValue) => {
      return previousValue * (currentValue + 1);
  }, 1) - 1;
}
