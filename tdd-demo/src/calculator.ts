export function calcDiscount(total: number): number {
  return total >= 100 ? total * 0.1 : 0;
}
