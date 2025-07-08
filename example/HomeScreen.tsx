import {
  SafeAreaView,
  ScrollView,
  Text,
  View,
  TouchableOpacity,
  StyleSheet,
  Alert
} from 'react-native';
import React, { useState, useEffect } from 'react';
import {
  initialize,
  SmileIDDocumentVerificationView,
  SmileIDSmartSelfieEnrollmentView,
  ExpoConfig
} from 'react-native-expo';

const PRODUCTS = [
  { title: 'Document Verification', key: 'documentVerification' },
  { title: 'SmartSelfie Enrollment', key: 'smartSelfieEnrollment' },
];

const config = new ExpoConfig(
  'your_partner_id', // partnerId
  'your_auth_token', // authToken
  'https://prod-lambda-url.com', // prodLambdaUrl
  'https://test-lambda-url.com' // testLambdaUrl
);

export default function HomeScreen() {
  const [selectedProduct, setSelectedProduct] = useState<string | null>(null);

  // Initialize SmileID SDK once when the component mounts
  useEffect(() => {
    const initSmileID = async () => {
      try {
        await initialize( true, true, config,undefined);
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

  const renderSelectedProductView = () => {
    if (!selectedProduct) return null;

    const containerStyle = [styles.flexContainer, styles.productContainer];

    switch (selectedProduct) {
      case 'documentVerification':
        return (
            <View style={containerStyle}>
              <SmileIDDocumentVerificationView style={styles.nativeView} />
            </View>
        );
      case 'smartSelfieEnrollment':
        return (
            <View style={containerStyle}>
              <SmileIDSmartSelfieEnrollmentView style={styles.nativeView} />
            </View>
        );
      default:
        return null;
    }
  };

  return (
      <SafeAreaView style={styles.flexContainer}>
        {selectedProduct ? (
            renderSelectedProductView()
        ) : (
            <ScrollView contentContainerStyle={styles.scrollContainer}>
              <Text style={styles.header}>Identity Verification</Text>
              <View style={styles.buttonContainer}>
                {PRODUCTS.map((product) => (
                    <TouchableOpacity
                        key={product.key}
                        style={styles.productButton}
                        onPress={() => handleProductPress(product.key)}
                    >
                      <Text style={styles.buttonText}>{product.title}</Text>
                    </TouchableOpacity>
                ))}
              </View>
            </ScrollView>
        )}
      </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  flexContainer: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  scrollContainer: {
    paddingVertical: 20,
  },
  header: {
    fontSize: 28,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 20,
    color: '#333',
  },
  buttonContainer: {
    paddingHorizontal: 20,
  },
  productButton: {
    backgroundColor: '#007AFF',
    borderRadius: 12,
    paddingVertical: 16,
    paddingHorizontal: 20,
    marginBottom: 15,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  buttonText: {
    color: '#fff',
    fontSize: 18,
    fontWeight: '600',
    textAlign: 'center',
  },
  productContainer: {
    padding: 10,
  },
  nativeView: {
    flex: 1,
    width: '100%',
  },
});
