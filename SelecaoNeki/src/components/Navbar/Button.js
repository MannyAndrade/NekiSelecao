import React, { useState } from "react";
import "./Button.css";

import Modal from "../ModalLogin/index";

export function Button() {
  const [isModalVisible, setIsModalVisible] = useState(false);

  return (
    <>
      <button
        type="button"
        className="btn"
        onClick={() => setIsModalVisible(true)}
      >
        Acessar
      </button>
      {isModalVisible ? (
        <Modal onClose={() => setIsModalVisible(false)}></Modal>
      ) : null}
    </>
  );
}
