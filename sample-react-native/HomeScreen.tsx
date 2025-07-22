import React, { useEffect, useState } from 'react';
import {
  Alert,
  FlatList,
  SafeAreaView,
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
} from 'react-native';
import {
  initialize,
  SmileIDDocumentVerificationView,
  SmileIDSmartSelfieEnrollmentView,
  SmileIDDocumentVerificationEnhancedView,
  ExpoConfig,
  ExpoDocumentVerificationRequest,
  ExpoEnhancedDocumentVerificationRequest,
  ExpoSmartSelfieEnrollmentRequest,
  SmileIDSmartSelfieAuthenticationEnhancedView,
  SmileIDSmartSelfieEnrollmentEnhancedView,
  SmileIDSmartSelfieAuthenticationView,
  SmileIDBiometricKYCView,
  ExpoBiometricKYCRequest,
  ExpoIdInfoRequest,
} from 'react-native-expo';
import DocumentVerificationEnhancedSvgIcon from './icons/DocumentVerificationEnhancedSvgIcon';
import BiometricKYCSvgIcon from './icons/BiometricKYCSvgIcon';
import DocumentVerificationSvgIcon from './icons/DocumentVerificationSvgIcon';
import SmartSelfieEnrollmentSvgIcon from './icons/SmartSelfieEnrollmentSvgIcon';
import SmartSelfieAuthenticationSvgIcon from './icons/SmartSelfieAuthenticationSvgIcon';

const PRODUCTS = [
  {
    title: 'SmartSelfie™ Enrollment',
    key: 'smartSelfieEnrollment',
    icon: <SmartSelfieEnrollmentSvgIcon width={48} height={48} />,
  },
  {
    title: 'SmartSelfie™ Authentication',
    key: 'smartSelfieAuth',
    icon: <SmartSelfieAuthenticationSvgIcon width={48} height={48} />,
  },
  {
    title: 'SmartSelfie™ Enrollment (Enhanced)',
    key: 'smartSelfieEnrollmentEnhanced',
    icon: <SmartSelfieEnrollmentSvgIcon width={48} height={48} />,
  },
  {
    title: 'SmartSelfie™ Authentication (Enhanced)',
    key: 'smartSelfieAuthEnhanced',
    icon: <SmartSelfieAuthenticationSvgIcon width={48} height={48} />,
  },
  {
    title: 'Biometric KYC',
    key: 'biometricKYC',
    icon: <BiometricKYCSvgIcon width={48} height={48} />,
  },
  {
    title: 'Document Verification',
    key: 'documentVerification',
    icon: <DocumentVerificationSvgIcon width={48} height={48} />,
  },
  {
    title: 'Enhanced Document Verification',
    key: 'enhancedDocumentVerification',
    icon: <DocumentVerificationEnhancedSvgIcon width={48} height={48} />,
  },
];

const config = new ExpoConfig(
    'your_partner_id', // partnerId
    'your_auth_token', // authToken
    'https://prod-lambda-url.com', // prodLambdaUrl
    'https://test-lambda-url.com' // testLambdaUrl
);

const documentVerificationConfig: ExpoDocumentVerificationRequest = {
  countryCode: 'NG',
  captureBothSides: false,
};

const smartSelfieEnrollmentConfig: ExpoSmartSelfieEnrollmentRequest = {
  showInstructions: false,
};

const enhancedDocumentVerificationConfig: ExpoEnhancedDocumentVerificationRequest = {
  countryCode: 'NG',
  captureBothSides: false,
};
const expoIdInfoRequest : ExpoIdInfoRequest = {
  country: 'NG',
  idType: 'NIN_V2',
  idNumber: '00000000000',
  entered: true,
};

const biometricKYCConfig: ExpoBiometricKYCRequest = {
  showInstructions: true,
  expoIdInfo: expoIdInfoRequest,
};

export default function HomeScreen() {
  const [selectedProduct, setSelectedProduct] = useState<string | null>(null);

  useEffect(() => {
    const initSmileID = async () => {
      try {
        await initialize(true, true, config, undefined);
        console.log('SmileID SDK initialized successfully');
      } catch (error) {
        console.error('SmileID SDK initialization failed:', error);
        Alert.alert('Initialization Error', 'Failed to initialize SmileID SDK');
      }
    };
    initSmileID();
  }, []);

  const handleProductPress = (productKey: string) => {
    setSelectedProduct(productKey);
  };

  const handleSuccessResult = (event: any) => {
    console.log('Success result:', event.nativeEvent);
    setSelectedProduct(null);
  };

  const handleError = (event: any) => {
    console.log('Got error:', event.nativeEvent);
    Alert.alert('Got error', event.nativeEvent?.error || 'Something went wrong');
    setSelectedProduct(null);
  };

  const renderSelectedProductView = () => {
    switch (selectedProduct) {
      case 'documentVerification':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDDocumentVerificationView
                  style={styles.nativeView}
                  config={documentVerificationConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}
              />
            </View>
        );
      case 'enhancedDocumentVerification':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDDocumentVerificationEnhancedView
                  style={styles.nativeView}
                  config={enhancedDocumentVerificationConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}
              />
            </View>
        );
      case 'smartSelfieEnrollment':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDSmartSelfieEnrollmentView
                  style={styles.nativeView}
                  config={smartSelfieEnrollmentConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}/>
            </View>
        );
      case 'smartSelfieEnrollmentEnhanced':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDSmartSelfieEnrollmentEnhancedView
                  style={styles.nativeView}
                  config={smartSelfieEnrollmentConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}
              />
            </View>
        );
      case 'smartSelfieAuth':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDSmartSelfieAuthenticationView
                  style={styles.nativeView}
                  config={smartSelfieEnrollmentConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}
              />
            </View>
        );
      case 'smartSelfieAuthEnhanced':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDSmartSelfieAuthenticationEnhancedView
                  style={styles.nativeView}
                  config={smartSelfieEnrollmentConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}
              />
            </View>
        );
      case 'biometricKYC':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDBiometricKYCView
                  style={styles.nativeView}
                  config={biometricKYCConfig}
                  onResult={handleSuccessResult}
                  onError={handleError}
              />
            </View>
        );
      default:
        return null;
    }
  };

  return (
      <SafeAreaView style={styles.container}>
        {selectedProduct ? (
            renderSelectedProductView()
        ) : (
            <>
              <View style={styles.headerBar}>
                <Text style={styles.appTitle}>Smile ID</Text>
              </View>

              <FlatList
                  data={PRODUCTS}
                  keyExtractor={(item) => item.key}
                  numColumns={2}
                  contentContainerStyle={styles.content}
                  columnWrapperStyle={styles.gridRow}
                  ListHeaderComponent={() => (
                      <Text style={styles.sectionTitle}>Test Our Products</Text>
                  )}
                  ListFooterComponent={() => (
                      <Text style={styles.version}>
                        Partner O05 • 1.6_11.0.4-SNAPSHOT_debug
                      </Text>
                  )}
                  renderItem={({ item }) => (
                      <TouchableOpacity
                          style={styles.card}
                          onPress={() => handleProductPress(item.key)}
                      >
                        <View style={styles.icon}>{item.icon}</View>
                        <Text style={styles.cardTitle}>{item.title}</Text>
                      </TouchableOpacity>
                  )}
              />
            </>
        )}
      </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#dedfc6',
  },
  headerBar: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingHorizontal: 16,
    paddingVertical: 12,
  },
  appTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    color: '#111',
  },
  content: {
    paddingHorizontal: 16,
    paddingBottom: 40,
  },
  sectionTitle: {
    fontSize: 22,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 16,
    color: '#222',
  },
  gridRow: {
    justifyContent: 'space-between',
    marginBottom: 16,
  },
  card: {
    backgroundColor: '#1b2471',
    width: '47%',
    borderRadius: 20,
    padding: 16,
    alignItems: 'center',
  },
  icon: {
    width: 48,
    height: 48,
    marginBottom: 12,
    overflow: 'hidden',
    alignItems: 'center',
    justifyContent: 'center',
  },
  cardTitle: {
    color: '#fff',
    fontSize: 14,
    textAlign: 'center',
    fontWeight: '600',
  },
  nativeContainer: {
    flex: 1,
    backgroundColor: '#fff',
  },
  nativeView: {
    flex: 1,
    width: '100%',
  },
  version: {
    textAlign: 'center',
    marginTop: 16,
    color: '#555',
    fontSize: 12,
  },
});
