import { test, expect } from '@jest/globals';
import { calcDiscount } from '../src/calculator';

test('gibt 10% Rabatt ab 100 €', () => {
  expect(calcDiscount(100)).toBe(10);
  expect(calcDiscount(250)).toBe(25);
});

test('kein Rabatt unter 100 €', () => {
  expect(calcDiscount(99)).toBe(0);
});
