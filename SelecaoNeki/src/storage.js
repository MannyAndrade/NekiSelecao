import AsyncStorage from "@react-native-community/async-storage";

// export const storeData = async (key, value) => {
//     try {
//         const jsonValue = JSON.stringify(value);

//         await AsyncStorage.setItem(`@storage_${key}`, jsonValue);
//     } catch (e) {
//         console.log("erro ao salvar dados");
//     }
// }

// export const getData = async (key) => {
//     try {
//         const value = await AsyncStorage.getItem(`@storage_${key}`)

//         return value != null ? JSON.parse(value) : null;
//     } catch (e) {
//         console.log("erro ao recuperar dados");
//     }
// }

function obterToken() {
  let token = localStorage.getItem("token");
  return token;
}

const obterUser = () => {
  return localStorage.getItem("username");
};

export const deleteKeys = async () => {
  try {
    await AsyncStorage.getAllKeys().then((keys) =>
      AsyncStorage.multiRemove(keys)
    );
  } catch (e) {
    console.log("erro ao deletar dados");
  }
};

export const deleteKey = async (key) => {
  try {
    await AsyncStorage.removeItem(`@storage_${key}`);
  } catch (e) {
    console.log("erro ao deletar dados");
  }
};

export const logout = () => {
  localStorage.clear();
  window.location.href = "/";
};

export default {
  obterToken,
  obterUser,
  deleteKeys,
  logout,
};
