import React from 'react';
import {Button, SafeAreaView, StyleSheet, useColorScheme, View} from 'react-native';
import {Colors} from 'react-native/Libraries/NewAppScreen';

const styles = StyleSheet.create({
  safeAreaView: {
    flex: 1,
  },
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});

function App() {
  return (
    <SafeAreaView
      style={[
        {
          backgroundColor: useColorScheme() === 'dark' ? Colors.darker : Colors.lighter,
        },
        styles.safeAreaView,
      ]}>
      <View style={styles.container}>
        <Button
          title="Hello World"
          onPress={() => {
            console.log('Hello World');
          }}
        />
      </View>
    </SafeAreaView>
  );
}

export default App;
