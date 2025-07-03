import { SafeAreaView, ScrollView, Text, View, TouchableOpacity, StyleSheet, Alert } from 'react-native';
import SmileIDExpo from 'react-native-expo';

const documentVerification = 'documentVerification';
const smartSelfieEnrollment = 'smartSelfieEnrollment';

const products = [
  {
    title: 'Document Verification',
    product: documentVerification,
    isAsync: false,
  },
  {
    title: 'SmartSelfie Enrollment',
    product: smartSelfieEnrollment,
    isAsync: false,
  },
];

export default function HomeScreen() {
  const handleProductPress = async (product) => {
    console.log('Product pressed:', product.title);
    
    try {
      switch (product.product) {
        case documentVerification:
          await SmileIDExpo.presentDocumentVerification();
          break;
        case smartSelfieEnrollment:
          await SmileIDExpo.presentSmartSelfieEnrollment();
          break;
        default:
          console.log('Unknown product:', product.product);
      }
    } catch (error) {
      console.error('Error presenting product:', error);
      Alert.alert('Error', 'Failed to present product screen');
    }
  };

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView style={styles.scrollView}>
        <Text style={styles.header}>Identity Verification</Text>
        <View style={styles.buttonContainer}>
          {products.map((product, index) => (
            <TouchableOpacity
              key={index}
              style={styles.productButton}
              onPress={() => handleProductPress(product)}
            >
              <Text style={styles.buttonText}>{product.title}</Text>
            </TouchableOpacity>
          ))}
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  scrollView: {
    flex: 1,
  },
  header: {
    fontSize: 28,
    fontWeight: 'bold',
    textAlign: 'center',
    margin: 20,
    color: '#333',
  },
  buttonContainer: {
    paddingHorizontal: 20,
    paddingVertical: 10,
  },
  productButton: {
    backgroundColor: '#007AFF',
    borderRadius: 12,
    paddingVertical: 16,
    paddingHorizontal: 20,
    marginBottom: 15,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
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
});