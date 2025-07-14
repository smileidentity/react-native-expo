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
  ExpoConfig,
  ExpoDocumentVerificationRequest,
} from 'react-native-expo';

const PRODUCTS = [
  { title: 'SmartSelfie™ Enrollment', key: 'smartSelfieEnrollment', icon: '📸' },
  { title: 'SmartSelfie™ Authentication', key: 'smartSelfieAuth', icon: '🧑‍🤝‍🧑' },
  { title: 'SmartSelfie™ Enrollment (Enhanced)', key: 'smartSelfieEnrollmentEnhanced', icon: '⚙️' },
  { title: 'SmartSelfie™ Authentication (Enhanced)', key: 'smartSelfieAuthEnhanced', icon: '✅' },
  { title: 'Biometric KYC', key: 'biometricKYC', icon: '🧬' },
  { title: 'Document Verification', key: 'documentVerification', icon: '📄' },
  { title: 'Enhanced Document Verification', key: 'enhancedDocumentVerification', icon: '📄' },
  { title: 'Enhanced KYC', key: 'enhancedKYC', icon: '📄' },
  { title: 'BVN Consent', key: 'bvnConsent', icon: '📄' },
];

const config = new ExpoConfig(
    'your_partner_id',
    'your_auth_token',
    'https://prod-lambda-url.com',
    'https://test-lambda-url.com'
);

const documentVerificationConfig: ExpoDocumentVerificationRequest = {
  countryCode: 'NG',
  captureBothSides: false,
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

  const handleProductPress = (key: string) => {
    setSelectedProduct(key);
  };

  const handleDocumentVerificationResult = (event: any) => {
    console.log('Document verification result:', event.nativeEvent);
    setSelectedProduct(null);
  };

  const handleDocumentVerificationError = (event: any) => {
    console.log('Document verification error:', event.nativeEvent);
    Alert.alert('Verification Error', event.nativeEvent?.error || 'Something went wrong');
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
                  onResult={handleDocumentVerificationResult}
                  onError={handleDocumentVerificationError}
              />
            </View>
        );
      case 'smartSelfieEnrollment':
        return (
            <View style={styles.nativeContainer}>
              <SmileIDSmartSelfieEnrollmentView style={styles.nativeView} />
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
                        <Text style={styles.icon}>{item.icon}</Text>
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
    fontSize: 36,
    marginBottom: 12,
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
