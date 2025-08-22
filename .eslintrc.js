module.exports = {
  root: true,
  parser: '@typescript-eslint/parser',
  extends: ['eslint:recommended'],
  plugins: ['@typescript-eslint'],
  ignorePatterns: ['build', 'android', 'ios', 'sample-expo', 'sample-react-native', 'node_modules', '.yarn'],
  parserOptions: {
    ecmaVersion: 2020,
    sourceType: 'module',
    ecmaFeatures: {
      jsx: true,
    },
  },
  env: {
    node: true,
    es6: true,
  },
  rules: {
    // Disable rules that might cause issues
    'no-unused-vars': 'off',
    'no-undef': 'off',
  },
};
