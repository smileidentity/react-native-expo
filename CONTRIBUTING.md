# Contributing to Smile ID Expo SDK

Thank you for your interest in contributing to the Smile ID Expo SDK! This document provides guidelines and information for contributors.

## Getting Started

### Prerequisites

Before contributing, ensure you have the following installed:

- **Node.js** (version 18.x or higher)
- **Yarn** (recommended) or npm
- **Expo CLI**: `npm install -g @expo/cli`
- **Android Studio** (for Android development)
- **Xcode** (version 16 or higher for iOS development and latest macOS, we're using Expo 53 which requires Xcode 16.2+)
- **Git**

### Initial Setup

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/your-username/react-native-expo.git
   cd react-native-expo
   ```

3. **Add the upstream remote**:
   ```bash
   git remote add upstream https://github.com/smileidentity/react-native-expo.git
   ```

## Development Setup

### Installing Dependencies

In the root project directory, install all dependencies:

```bash
yarn install
```

### Running the Sample Apps

We provide a sample app that demonstrates SDK integration and showcases Smile ID products.

#### Android (Expo Sample)

```bash
cd sample-expo
yarn install
npx expo run:android
```

#### Android (React Native Sample)

```bash
cd sample-react-native
yarn install
npx react-native run-android
```

#### iOS (Expo Sample)

First, install iOS dependencies:

```bash
cd sample-expo/ios
yarn install
pod install
cd ..
```

Then run the app:
```bash
npx expo run:ios
```

#### iOS (React Native Sample)

First, install iOS dependencies:

```bash
cd sample-react-native/ios
yarn install
pod install
cd ..
```

Then run the app:
```bash
npx react-native run-ios
```

### Development Server

For development with hot reloading:

#### Expo Sample

```bash
cd sample-expo
yarn install
npx expo start
```

#### React Native Sample

```bash
cd sample-react-native
yarn install
npx react-native start
```

## Development Workflow

### Creating a Feature Branch

1. **Sync with upstream**:
   ```bash
   git checkout main
   git pull upstream main
   ```

2. **Create a feature branch**:
   ```bash
   git checkout -b feature/your-feature-name
   ```

### Making Changes

1. Make your changes in the appropriate files
2. Test your changes thoroughly
3. Add or update tests as necessary
4. Update documentation if needed

### Committing Changes

We follow [Conventional Commits](https://www.conventionalcommits.org/):

```bash
git commit -m "feat: add new identity verification method"
git commit -m "fix: resolve crash on Android API level 21"
git commit -m "docs: update installation instructions"
```

**Commit Types:**
- `feat`: New features
- `fix`: Bug fixes
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

## Code Standards

### TypeScript

- Use TypeScript for all new code
- Ensure proper type definitions
- Avoid using `any` type when possible

### Code Style

We use ESLint and Prettier for code formatting:

```bash
# Check linting
yarn lint

# Fix linting issues
yarn lint:fix

# Format code
yarn format
```

### Naming Conventions

// todo add conventions

## Testing

### Running Tests

```bash
# Run all tests
yarn test

# Run tests in watch mode
yarn test:watch

# Run tests with coverage
yarn test:coverage
```

### Test Requirements

- Test on both iOS and Android platforms

## Pull Request Process

### Before Submitting

1. **Ensure all tests pass**: `yarn test`
2. **Check linting**: `yarn lint`
3. **Update documentation** if necessary
4. **Test on both platforms** (iOS and Android)
5. **Rebase your branch** on the latest main:
   ```bash
   git fetch upstream
   git rebase upstream/main
   ```

### Submitting a Pull Request

1. **Push your branch** to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```

2. **Create a Pull Request** on GitHub with:
   - Clear title describing the change
   - Detailed description of what changed and why
   - Screenshots/videos for UI changes
   - References to related issues

## Issue Reporting

### Bug Reports

When reporting bugs, include:

- **Environment details** (OS, device, Expo version)
- **Steps to reproduce** the issue
- **Expected vs actual behavior**
- **Screenshots or videos** if applicable
- **Logs or error messages**

### Feature Requests

For feature requests, provide:

- **Clear description** of the proposed feature
- **Use case** and motivation
- **Proposed implementation** (if applicable)

## Project Structure


## Common Commands

```bash
# Install dependencies
yarn install

# Start development server
yarn start

# Run tests
yarn test

# Lint code
yarn lint

# Build the SDK
yarn build

# Release new version
yarn release

# Clean build artifacts
yarn clean
```

## Troubleshooting

### Common Issues

**Metro bundler issues:**
```bash
npx expo start --clear
```

**iOS build issues:**
```bash
cd sample-expo/ios
pod install --repo-update
```

**Android build issues:**
```bash
cd sample-expo/android
./gradlew clean
```

**Dependencies out of sync:**
```bash
yarn install
cd sample-expo
yarn install
```

### Getting Help

- Check existing [GitHub Issues](https://github.com/smileidentity/react-native-expo/issues)
- Review the [documentation](https://docs.usesmileid.com/integration-options/mobile)

## Code of Conduct


## License

By contributing to this project, you agree that your contributions will be licensed under the same license as the project.

---

Thank you for contributing to Smile ID Expo SDK! 🎉