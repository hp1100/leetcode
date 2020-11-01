// 杨辉三角			
long[][] C = new long[31 + 1][31 + 1];
for (int i = 0; i <= 31; i++) {
  C[i][0] = 1;
  for (int j = 1; j <= i; j++) {
    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
  }
}
