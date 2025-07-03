import { SafeAreaView, ScrollView, Text, View, TouchableOpacity, StyleSheet } from 'react-native';

const documentCapture = 'documentCapture';
const smartSelfieEnrollment = 'smartSelfieEnrollment';

const products = [
  {
    title: 'Document Capture',
    product: documentCapture,
    isAsync: false,
  },
  {
    title: 'SmartSelfie Enrollment',
    product: smartSelfieEnrollment,
    isAsync: false,
  },
];

export default function HomeScreen() {
  const handleProductPress = (product) => {
    console.log('Product pressed:', product.title);
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