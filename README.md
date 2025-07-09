# Smile ID Expo SDK

Smile ID provides premier solutions for Real Time Digital KYC, Identity Verification, User Onboarding, and User Authentication across Africa.

If you haven’t already, [sign up](https://www.usesmileid.com/schedule-a-demo/) for a free Smile ID account, which comes with Sandbox access.

Please see [CHANGELOG.md](CHANGELOG.md) or [Releases](https://github.com/smileidentity/react-native/releases) for the most recent version and release notes.

## Getting Started

Full documentation is available at [Smile ID Documentation](https://docs.usesmileid.com/integration-options/mobile/getting-started)

### 0. Requirements

* Node.js >=18.0
* React Native >=0.79
* A `smile_config.json` file from [Smile ID Portal](https://portal.usesmileid.com/sdk)
* See: [Android Requirements](https://github.com/smileidentity/android) for Android specific requirements.
* See: [iOS Requirements](https://github.com/smileidentity/ios) for iOS specific requirements.

### 1. Dependency

// todo: add this later

## 2. SDK Initialization

The Smile ID Expo SDK offers three flexible initialization methods to suit different development needs.

```typescript
import { initialize, ExpoConfig } from 'react-native-expo';
```

### Option 1: Configuration File (Recommended)

This method uses a `smile_config.json` file containing your configuration settings.

**Setup Requirements:**
- **iOS**: Add `smile_config.json` to your copy bundle phases in your iOS target
- **Android**: Place `smile_config.json` in your assets folder

```typescript
// Initialize using configuration file
initialize(true);
```

### Option 2: Programmatic Configuration

```typescript
// Create configuration object with your Smile ID portal credentials
const config = new ExpoConfig(
  'your_partner_id',              // Partner ID from Smile ID portal
  'your_auth_token',              // Authentication token
  'https://prod-lambda-url.com',  // Production lambda URL
  'https://test-lambda-url.com'   // Test lambda URL
);

// Initialize with configuration object
initialize(true, true, config);
```

### Option 3: Configuration with API Key

```typescript
// Use the same config object from Option 2
const config = new ExpoConfig(
  'your_partner_id',
  'your_auth_token', 
  'https://prod-lambda-url.com',
  'https://test-lambda-url.com'
);

// Initialize with configuration and API key
initialize(true, true, config, 'YOUR_API_KEY');
```

## 3. Document Verification

The SDK currently supports Document Verification with a simple, integrated component approach.

### Configuration Setup

First, create a document verification configuration object:

```typescript
import { ExpoDocumentVerificationRequest } from 'react-native-expo';

const documentVerificationConfig: ExpoDocumentVerificationRequest = {
  countryCode: 'NG',        // ISO country code for document type
  captureBothSides: false,  // Whether to capture both sides of document
  // Add additional parameters as needed for your use case
};
```

Additional parameters can be added based on your verification requirements

### Implementation

Integrate the document verification component into your React Native view:

```typescript
import { SmileIDDocumentVerificationView } from 'react-native-expo';

// Component implementation
<SmileIDDocumentVerificationView 
  style={styles.nativeView} 
  config={documentVerificationConfig}
  onResult={handleDocumentVerificationResult}
  onError={handleDocumentVerificationError}
/>
```

### Event Handlers

Implement the required callback functions to handle verification results:

```typescript
// Handle successful verification
const handleDocumentVerificationResult = (result: DocumentVerificationResult) => {
  console.log('Document verification successful:', result);
  // Process the verification result
};

// Handle verification errors
const handleDocumentVerificationError = (error: DocumentVerificationError) => {
  console.error('Document verification failed:', error);
  // Handle error appropriately
};
```

**Component Props:**
- `style`: React Native StyleSheet for component styling
- `config`: Document verification configuration object
- `onResult`: Callback function for successful verification
- `onError`: Callback function for error handling

This implementation provides a complete document verification flow with comprehensive error handling and result processing capabilities.

## Getting Help

For detailed documentation, please visit [Smile ID Documentation](https://docs.usesmileid.com/integration-options/mobile)

If you require further assistance, you can [file a support ticket](https://portal.usesmileid.com/partner/support/tickets) or [contact us](https://www.usesmileid.com/contact-us/)

## Contributing

Bug reports and Pull Requests are welcomed. Please see [CONTRIBUTING.md](CONTRIBUTING.md)

## License

[MIT License](LICENSE)
